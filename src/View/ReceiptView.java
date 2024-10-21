package View;
import java.util.Scanner;

import Controller.ReceiptController;
import Model.Receipt;

public class ReceiptView {
	
	private ReceiptController controller;

	public ReceiptView() {
        this.controller = new ReceiptController();
    }

    public void displayReceipts() {
        System.out.println("=== Receipts ===");
        for (Receipt receipt : controller.getAllReceipts()) {
            System.out.println(receipt);
        }
    }

    public void addReceipt() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        // 버퍼 비우기: nextDouble() 이후 남은 개행 문자를 처리
        scanner.nextLine();

        System.out.print("Payment Date (YYYY-MM-DD HH:MM:SS): ");
        String paymentDate = scanner.nextLine();  // 공백을 포함한 전체 입력을 받기 위해 nextLine() 사용

        System.out.print("Card Last 4 Digits: ");
        String cardLastFourDigits = scanner.next();

        // 입력 길이가 4자리를 초과하는 경우 자르기
        if (cardLastFourDigits.length() > 4) {
            cardLastFourDigits = cardLastFourDigits.substring(0, 4);
        }

        // 버퍼 비우기: next() 호출 후 남은 개행 문자 처리
        scanner.nextLine();

        System.out.print("Shop: ");
        String shop = scanner.nextLine();  // 전체 라인을 받기 위해 nextLine() 사용

        try {
            // Receipt 객체 생성 및 추가
            Receipt receipt = new Receipt(0, productName, price, paymentDate, cardLastFourDigits, shop);
            controller.addReceipt(receipt);
        } catch (Exception e) {
            e.printStackTrace();  // 에러 메시지를 출력하는 것이 디버깅에 유리합니다.
        }

        System.out.println("Receipt added successfully.");
    }
    
}