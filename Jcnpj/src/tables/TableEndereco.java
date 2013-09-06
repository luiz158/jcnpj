package tables;

import helpers.NumberHelper;

import java.util.List;

import model.Empresa;

import org.jsoup.nodes.Element;

public class TableEndereco {

	public static void tratarTable(Element element, Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {

			if (ba.toString().contains("CEP")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setCep(NumberHelper.getNumbers(elements.get(0)
						.ownText().trim()));
			}

			if (ba.toString().contains("BAIRRO")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setBairro(elements.get(0).ownText().trim());
			}

			if (ba.toString().contains("MUNIC")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setMunicipio(elements.get(0).ownText().trim());
			}

			if (ba.toString().contains("UF")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setUf(elements.get(0).ownText().trim());
			}

			i++;
		}
	}

}
