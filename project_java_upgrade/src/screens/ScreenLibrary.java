package screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import repository.BookRepository;
import repository.UserRepository;

public class ScreenLibrary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeUsuario;
	private JTextField textFieldISBN;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
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
					frame.setLocationRelativeTo(null);
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
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 547, 147);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCadastroUser = new JLabel("Cadastro de Usuario");
		lblCadastroUser.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblCadastroUser.setBounds(10, 10, 171, 13);
		panel.add(lblCadastroUser);

		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setBounds(103, 48, 415, 19);
		panel.add(tfNomeUsuario);
		tfNomeUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 15));
		lblNewLabel.setBounds(20, 46, 104, 19);
		panel.add(lblNewLabel);

		JButton btnCadastrarUsuario = new JButton("Cadastrar Usuario");
		btnCadastrarUsuario.setBackground(new Color(192, 192, 192));
		btnCadastrarUsuario.setBounds(355, 88, 164, 23);
		panel.add(btnCadastrarUsuario);
		
		JLabel lblUsuarioLog = new JLabel("");
		lblUsuarioLog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuarioLog.setBounds(20, 105, 269, 31);
		panel.add(lblUsuarioLog);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 169, 547, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro Livros");
		lblNewLabel_1.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(20, 10, 135, 13);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ISBN :\r\n");
		lblNewLabel_2.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(30, 45, 67, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Titulo : ");
		lblNewLabel_3.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(30, 81, 67, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Autor : ");
		lblNewLabel_4.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(30, 119, 67, 13);
		panel_1.add(lblNewLabel_4);

		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(107, 44, 415, 19);
		panel_1.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(107, 80, 415, 19);
		panel_1.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(107, 118, 415, 19);
		panel_1.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.setBackground(new Color(192, 192, 192));
		btnCadastrarLivro.setBounds(363, 153, 159, 23);
		panel_1.add(btnCadastrarLivro);
		
		JLabel lblLivroLog = new JLabel("");
		lblLivroLog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLivroLog.setBounds(20, 143, 269, 31);
		panel_1.add(lblLivroLog);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		JButton btnEmprestarLivro = new JButton("Realizar Emprestimo");
		btnEmprestarLivro.setBackground(new Color(192, 192, 192));
		btnEmprestarLivro.setBounds(358, 143, 164, 23);
		panel_2.add(btnEmprestarLivro);
		
		JLabel lblEmprestimoLog = new JLabel("");
		lblEmprestimoLog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmprestimoLog.setBounds(24, 135, 269, 31);
		panel_2.add(lblEmprestimoLog);

		TextArea textAreaUsuarios = new TextArea();
		textAreaUsuarios.setBounds(590, 60, 532, 97);
		contentPane.add(textAreaUsuarios);

		TextArea textAreaLivros = new TextArea();
		textAreaLivros.setBounds(590, 223, 532, 129);
		contentPane.add(textAreaLivros);

		TextArea textAreaLivrosEmprestados = new TextArea();
		textAreaLivrosEmprestados.setBounds(590, 406, 532, 141);
		contentPane.add(textAreaLivrosEmprestados);

		JLabel lblMostarUsuarios = new JLabel("Usuarios:");
		lblMostarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMostarUsuarios.setBounds(590, 10, 164, 44);
		contentPane.add(lblMostarUsuarios);

		JLabel lblMostarLivros = new JLabel("Livros:");
		lblMostarLivros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMostarLivros.setBounds(590, 169, 164, 44);
		contentPane.add(lblMostarLivros);

		JLabel lblMostarLivrosEmprestados = new JLabel("Livros Emprestados:");
		lblMostarLivrosEmprestados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMostarLivrosEmprestados.setBounds(590, 358, 229, 44);
		contentPane.add(lblMostarLivrosEmprestados);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(192, 192, 192));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtualizar.setBounds(976, 10, 146, 32);
		contentPane.add(btnAtualizar);
		
		
		// Função do botao de cadastrar usuario
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRepository.UserInsert(tfNomeUsuario.getText());
				lblUsuarioLog.setText("Usuario registrado com sucesso!");
			}
		});
		
		// Função do botao de cadastrar livro
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookRepository.inserirLivro(textFieldTitulo.getText(),textFieldAutor.getText(),textFieldISBN.getText());
				lblLivroLog.setText("Livro cadastrado com sucesso!");
			}
		});
		
		// Atualiza os consoles de exibição de dados
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> usuarios = UserRepository.UserSelect();

				if (usuarios != null) {
					StringBuilder usuariosTexto = new StringBuilder();
					for (String usuario : usuarios) {
						usuariosTexto.append(usuario).append("\n");
					}

					textAreaUsuarios.setText(usuariosTexto.toString());
				} else {
					System.out.println("Nenhum usuario encontrado!");
				}
				
				ArrayList<String> livros = BookRepository.selectLivro();
				
				if (livros != null) {
					StringBuilder livrosTexto = new StringBuilder();
					for (String livro : livros) {
						livrosTexto.append(livro).append("\n");
					}
	
					textAreaLivros.setText(livrosTexto.toString());
				} else {
					System.out.println("Nenhum livro encontrado!");
				}
				
				
			}
		});
	}
}
