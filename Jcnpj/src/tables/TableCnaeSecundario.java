package tables;

import helpers.NumberHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cnae;
import model.Empresa;

import org.jsoup.nodes.Element;

public class TableCnaeSecundario {

	private static Map<String, String> map = new HashMap<>();

	public static Map<String, String> tratarTable(Element element,
			Empresa empresa) {
		int i = 0;
		List<Element> cabecalho = element.getElementsByTag("font");

		for (Element ba : cabecalho) {

			if (ba.toString().contains("O DAS ATIVIDADES ECON")) {
				List<Element> elements = cabecalho.get(i + 1).getElementsByTag(
						"b");

				String[] s = elements.get(0).ownText().split("-");
				Cnae cnae = new Cnae();
				cnae.setDescricao(s[s.length - 1]);
				cnae.setNumero(NumberHelper.getNumbers(elements.get(0)
						.ownText()));

				empresa.setCnaesSecundarios(Arrays.asList(cnae));
			}
			i++;
		}
		return map;
	}

}
