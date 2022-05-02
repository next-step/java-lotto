package step2;

import step2.domain.PurchaseCount;
import step2.domain.PurchaseList;
import step2.view.InputView;
import step2.view.OutPutView;
import step2.view.dto.PurchaseCountDto;
import step2.view.dto.PurchaseListDto;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();

        PurchaseCount purchaseCount = new PurchaseCount(inputView.askPurchaseAmount());
        outPutView.show(new PurchaseCountDto(purchaseCount).toString());

        PurchaseList purchaseList = new PurchaseList(purchaseCount);
        outPutView.show(new PurchaseListDto(purchaseList).toString());

        inputView.close();
    }
}
