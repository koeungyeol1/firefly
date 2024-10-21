package Controller;
import java.util.List;

import Model.Receipt;
import Service.ReceiptService;


public class ReceiptController {
	
	
	private ReceiptService service;

    public ReceiptController() {
        this.service = new ReceiptService();
    }

    public List<Receipt> getAllReceipts() {
        return service.getAllReceipts();
    }

    public void addReceipt(Receipt receipt) {
        service.addReceipt(receipt);
    }


}
