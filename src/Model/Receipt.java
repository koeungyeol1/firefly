package Model;

public class Receipt {

	private int id;
    private String productName;
    private double price;
    private String paymentDate;
    private String cardLastFourDigits;
    private String shop;
	public Receipt(int id, String productName, double price, String paymentDate, String cardLastFourDigits,
			String shop) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.paymentDate = paymentDate;
		this.cardLastFourDigits = cardLastFourDigits;
		this.shop = shop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getCardLastFourDigits() {
		return cardLastFourDigits;
	}
	public void setCardLastFourDigits(String cardLastFourDigits) {
		this.cardLastFourDigits = cardLastFourDigits;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
    
	@Override
	public String toString() {
	    return String.format("ID: %d, Product: %s, Price: %.2f, Date: %s, Card: %s, shop: %s", 
	                         id, productName, price, paymentDate, cardLastFourDigits, shop);
	}
    
}
