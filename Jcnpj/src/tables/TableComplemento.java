package tables;

import java.util.List;

import model.Empresa;

import org.jsoup.nodes.Element;

public class TableComplemento {

	public static void tratarTable(Element element, Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {

			if (ba.toString().contains("LOGRADOURO")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setLogradouro(elements.get(0).ownText().trim());
			}

			if (ba.toString().contains("MERO")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setNumero(elements.get(0).ownText().trim());
			}

			if (ba.toString().contains("COMPLEMENTO")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setComplemento(elements.get(0).ownText().trim());
			}

			i++;
		}
	}

}
