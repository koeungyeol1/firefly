package Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Receipt;

public class ReceiptRepository {

	private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/firefly";
        String user = "root";
        String password = "0912";
        return DriverManager.getConnection(url, user, password);
    }
	
	
	public List<Receipt> findAll() {
        List<Receipt> receipts = new ArrayList<>();
        String query = "SELECT * FROM receipts";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Receipt receipt = new Receipt(
                    rs.getInt("id"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getString("payment_date"),
                    rs.getString("card_last_four_digits"),
                    rs.getString("shop")
                );
                receipts.add(receipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receipts;
    }
	
	
	
	// 데이터를 삽입하는 메서드
    public void save(Receipt receipt) {
        String query = "INSERT INTO receipts (product_name, price, payment_date, card_last_four_digits, shop) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, receipt.getProductName());
            pstmt.setDouble(2, receipt.getPrice());
            pstmt.setString(3, receipt.getPaymentDate());
            pstmt.setString(4, receipt.getCardLastFourDigits());
            pstmt.setString(5, receipt.getShop());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
