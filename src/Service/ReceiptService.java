package Service;
import java.util.List;

import Model.Receipt;
import Repository.ReceiptRepository;

public class ReceiptService {

	
	private ReceiptRepository repository;

    public ReceiptService() {
        this.repository = new ReceiptRepository();
    }

    public List<Receipt> getAllReceipts() {
        return repository.findAll();
    }

    public void addReceipt(Receipt receipt) {
        repository.save(receipt);
    }

    // 추가적으로 업데이트, 삭제 등의 기능을 추가할 수 있음
}