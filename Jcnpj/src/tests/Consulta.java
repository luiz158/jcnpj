package tests;

import helpers.ConsultaHelper;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Empresa;

public class Consulta {

	public static void main(String[] args) throws IOException {

		String img = ConsultaHelper.capturaCaptcha("15551588000149");

		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		URL url = new URL(img);
		BufferedImage image = ImageIO.read(url);

		JLabel label = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		String idLetras = JOptionPane.showInputDialog("Digite o captcha");

		Empresa empresa = ConsultaHelper.consulta("15551588000149", idLetras);

		if (empresa != null && empresa.getNome() != null) {
			System.out.println("Empresa     " + empresa.getNome());
			System.out.println("Bairro      " + empresa.getBairro());
			System.out.println("CEP         " + empresa.getCep());
			System.out.println("UF          " + empresa.getUf());
			System.out.println("CNAE PRIM.  "
					+ empresa.getCnaePrimario().getNumero() + " - "
					+ empresa.getCnaePrimario().getDescricao());
		} else {
			System.out.println("Texto da imagem incorreto.");
		}

		System.exit(0);
	}

}