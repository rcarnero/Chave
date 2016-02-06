package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaRank extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaRank frame = new JanelaRank();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaRank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField.setBounds(135, 32, 168, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoJogador = new JLabel("Nome do jogador:");
		lblNomeDoJogador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNomeDoJogador.setBounds(10, 29, 115, 30);
		contentPane.add(lblNomeDoJogador);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(106, 100, 98, 42);
		contentPane.add(btnNewButton);
	}
}
