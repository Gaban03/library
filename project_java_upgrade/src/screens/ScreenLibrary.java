package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ScreenLibrary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenLibrary frame = new ScreenLibrary();
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
	public ScreenLibrary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 547, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastroUser = new JLabel("Cadastro de Usuario");
		lblCadastroUser.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblCadastroUser.setBounds(10, 10, 171, 13);
		panel.add(lblCadastroUser);
		
		textField = new JTextField();
		textField.setBounds(103, 48, 415, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblNewLabel.setBounds(20, 46, 104, 19);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 169, 547, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro Livros");
		lblNewLabel_1.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(20, 10, 135, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN :\r\n");
		lblNewLabel_2.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(30, 61, 67, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Titulo : ");
		lblNewLabel_3.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(30, 97, 67, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Autor : ");
		lblNewLabel_4.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(30, 135, 67, 13);
		panel_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 60, 415, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 96, 415, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 134, 415, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 366, 547, 177);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Emprestimo do Livro");
		lblNewLabel_5.setFont(new Font("Verdana", Font.ITALIC, 16));
		lblNewLabel_5.setBounds(24, 10, 237, 35);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ISBN ");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_6.setBounds(24, 67, 113, 13);
		panel_2.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(24, 90, 96, 19);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Registro Usuario");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_7.setBounds(233, 69, 164, 13);
		panel_2.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(232, 90, 164, 19);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
	}
}
