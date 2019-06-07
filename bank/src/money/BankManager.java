package money;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BankManager {
	private static JTextField idT;
	private static JTextField nameT;
	private static JTextField ageT;
	private static JTextField telT;

	public static void main(String[] args) {
		
		BankDTO dto = new BankDTO();
		
		JFrame f = new JFrame();
		f.setTitle("BankTest");
		
		f.setSize(671,736);
		
		ImageIcon icon = new ImageIcon("bank.jpeg");
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel welcome = new JLabel("환영합니다!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 70));
		f.getContentPane().add(welcome, BorderLayout.NORTH);
		JLabel imgL = new JLabel();
		imgL.setHorizontalAlignment(SwingConstants.CENTER);
		
		imgL.setIcon(icon);
		
		f.getContentPane().add(imgL, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		panel_2.add(lblNewLabel);
		
		idT = new JTextField();
		idT.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_2.add(idT);
		idT.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Consolas", Font.BOLD, 20));
		panel_2.add(lblName);
		
		nameT = new JTextField();
		nameT.setFont(new Font("굴림", Font.PLAIN, 15));
		nameT.setColumns(10);
		panel_2.add(nameT);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Consolas", Font.BOLD, 20));
		panel_2.add(lblAge);
		
		ageT = new JTextField();
		ageT.setFont(new Font("굴림", Font.PLAIN, 15));
		ageT.setColumns(10);
		panel_2.add(ageT);
		
		JLabel lblTel = new JLabel("TEL");
		lblTel.setFont(new Font("Consolas", Font.BOLD, 20));
		panel_2.add(lblTel);
		
		telT = new JTextField();
		telT.setFont(new Font("굴림", Font.PLAIN, 15));
		telT.setColumns(10);
		panel_2.add(telT);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("회원정보등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setId(idT.getText());
				dto.setName(nameT.getText());
				dto.setAge(ageT.getText());
				dto.setTel(telT.getText());

				BankDAO dao = new BankDAO();
				
				try {
					dao.insert(dto);
					JOptionPane.showMessageDialog(null, "회원정보가 등록되었습니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 17));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("회원 전체검색");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BankDAO dao = new BankDAO();
				
				try {
					dao.selectAll();
					ArrayList list = dao.selectAll();
					System.out.println("----------------------");
					
					for (int i = 0; i < list.size(); i++) {
						BankDTO dto = (BankDTO)list.get(i);
						System.out.println("야이디 : " + dto.getId());
						System.out.println("이름 : " + dto.getName());
						System.out.println("나이 : " + dto.getAge());
						System.out.println("전화번호 : " + dto.getTel());
						System.out.println("----------------------");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 17));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BankDAO dao = new BankDAO();
				
				String id = idT.getText();
				String tel = telT.getText();
				
				
				try {
					dao.update(id, tel);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 17));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("탈퇴");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BankDAO dao = new BankDAO();
				
				String id = idT.getText();
				
				try {
					dao.delete(id);
					JOptionPane.showMessageDialog(null, "회원삭제 완료");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		});
		btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 17));
		panel_1.add(btnNewButton_2);
		
		f.setVisible(true);
		
	}

}
