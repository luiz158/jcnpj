package tables;

import helpers.NumberHelper;

import java.util.List;

import model.Cnae;
import model.Empresa;

import org.jsoup.nodes.Element;

public class TableCnaePrimario {

	public static void tratarTable(Element element, Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {

			if (ba.toString().contains("DA ATIVIDADE ECON")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				String[] s = elements.get(0).ownText().split("-");
				Cnae cnae = new Cnae();
				cnae.setDescricao(s[s.length - 1]);
				cnae.setNumero(NumberHelper.getNumbers(elements.get(0)
						.ownText()));

				empresa.setCnaePrimario(cnae);

			}
			i++;
		}
	}

}
