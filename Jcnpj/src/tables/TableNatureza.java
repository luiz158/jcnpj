package tables;

import java.util.List;

import model.Empresa;

import org.jsoup.nodes.Element;

public class TableNatureza {

	public static void tratarTable(Element element, Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {

			if (ba.toString().contains("O DA NATUREZA JUR")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				empresa.setDescricaoNaturezaJuridica(elements.get(0).ownText()
						.trim());
			}

			i++;
		}
	}

}
