package tables;

import helpers.NumberHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Empresa;

import org.jsoup.nodes.Element;

public class TableEmpresa {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void tratarTable(final Element element, Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {
			if (ba.toString().contains("COMPROVANTE DE INSCR"))
				continue;

			if (ba.toString().contains("MERO DE INSCR")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setCnpj(NumberHelper.getNumbers(elements.get(0)
						.ownText().trim()));
			}

			if (ba.toString().contains("DATA DE ABERTURA")) {
				List<Element> elements = cabecalho.get(i + 2).getElementsByTag(
						"b");

				try {
					empresa.setDataAbertura(sdf.parse(elements.get(0).ownText()
							.trim()));
				} catch (ParseException e) {
					empresa.setDataAbertura(null);
				}
			}
			i++;
		}
	}

}
