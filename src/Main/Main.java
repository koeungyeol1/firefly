package Main;

import View.ReceiptView;

public class Main {
	public static void main(String[] args) {
        ReceiptView view = new ReceiptView();
        
        // 예시로 데이터 조회 및 추가
        view.displayReceipts();
        view.addReceipt();
        view.displayReceipts();
    }
	
}
