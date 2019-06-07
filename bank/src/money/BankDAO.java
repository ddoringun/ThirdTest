package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {
	
	Connection con;
	PreparedStatement ps;
	String url = "jdbc:mysql://localhost:3306/bank";
	String user = "root";
	String password = "1234"; 
	ResultSet rs;
	
	public void insert(BankDTO dto) throws Exception { // 회원정보 등록
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 설정 완료");
		
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB 연결 완료");
		
		String sql = "insert into bank values(?,?,?,?)";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAge());
		ps.setString(4, dto.getTel());
		
		System.out.println("객체화 완료");
		
		ps.executeUpdate();
		System.out.println("등록 완료");
		System.out.println("--------------");
		
		ps.close();
		con.close();
		
	} // insert end
	
	public void update(String id, String tel) throws Exception{  // 정보 수정
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 설정 완료");
		
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB 연결 완료");
		
		String sql = "update bank set tel = ? where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ps.setString(2, id);
		System.out.println("객체화 완료");
		
		ps.executeUpdate();
		System.out.println("수정 완료");
		System.out.println("--------------");
		
		ps.close();
		con.close();
		
	}  //update end
	
	public void delete(String id) throws Exception {  // 회원 삭제
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 설정 완료");
		
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB 연결 완료");
		
		String sql = "delete from bank where id = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("객체화 완료");
		
		ps.executeUpdate();
		System.out.println("삭제 완료");
		System.out.println("--------------");
		
		ps.close();
		con.close();
		
	} // delete end;
	
	public ArrayList selectAll() throws Exception{  // 회원정보 전체 검색
		
		ArrayList list = new ArrayList();
		BankDTO dto = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 설정 완료");
		
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB 연결 완료");
		
		String sql = "select * from bank";
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		System.out.println("전송 완료");
		System.out.println("--------------");
		
		while(rs.next()) {
			dto = new BankDTO();
			String id = rs.getString(1);
			String name = rs.getString(2);
			String age = rs.getString(3);
			String tel = rs.getString(4);
			
			dto.setId(id);
			dto.setName(name);
			dto.setAge(age);
			dto.setTel(tel);
			
			list.add(dto);
			
		}  // while end
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
		
	} // select end
}
