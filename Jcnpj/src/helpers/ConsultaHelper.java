package helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Empresa;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import tables.TableCnaePrimario;
import tables.TableCnaeSecundario;
import tables.TableComplemento;
import tables.TableDescricao;
import tables.TableEmpresa;
import tables.TableEndereco;
import tables.TableNatureza;

public class ConsultaHelper {

	private static Map<String, String> cookies = new HashMap<>();

	private static String viewState = "";

	private static Empresa empresa = new Empresa();

	public static String capturaCaptcha(String cnpj) {
		try {

			Response response = Jsoup
					.connect(
							"http://www.receita.fazenda.gov.br/pessoajuridica/cnpj/cnpjreva/valida.asp")
					.method(Method.POST).execute();

			cookies = response.cookies();

			Document document = response.parse();

			Element img = document.select("#imgcaptcha").first();
			String imgSrc = img.attr("src");

			Element elemetos1 = document.select("#viewstate").first();
			viewState = elemetos1.attr("value");

			return "http://www.receita.fazenda.gov.br" + imgSrc;

		} catch (IOException ex) {
			return null;
		}
	}

	public static Empresa consulta(String cnpj, String captcha) {
		try {
			Map<String, String> query = new HashMap<>();
			query.put("captcha", captcha.trim());
			query.put("cnpj", cnpj.trim());
			query.put("viewstate", viewState.trim());
			query.put("origem", "comprovante");
			query.put("search_type", "cnpj");
			query.put("captchaAudio", "");
			query.put("submit1", "Consultar");

			Connection.Response resposta;
			resposta = Jsoup
					.connect(
							"http://www.receita.fazenda.gov.br/pessoajuridica/cnpj/cnpjreva/valida.asp")
					.data(query).cookies(cookies)
					.method(Connection.Method.POST).execute();

			Document document = resposta.parse();
			Elements font = document.select("table table");

			for (int i = 0; i < font.size(); i++) {
				if (i != 0 && i < 10) {
					if (i == 2) {
						TableEmpresa.tratarTable(font.get(i), empresa);
					} else if (i == 3) {
						TableDescricao.tratarTable(font.get(i), empresa);
					} else if (i == 5) {
						TableCnaePrimario.tratarTable(font.get(i), empresa);
					} else if (i == 6) {
						TableCnaeSecundario.tratarTable(font.get(i), empresa);
					} else if (i == 7) {
						TableNatureza.tratarTable(font.get(i), empresa);
					} else if (i == 8) {
						TableComplemento.tratarTable(font.get(i), empresa);
					} else if (i == 9) {
						TableEndereco.tratarTable(font.get(i), empresa);
					}
				}
			}

			return empresa;
		} catch (IOException ex) {
			return null;
		}
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public String getViewState() {
		return viewState;
	}

}
