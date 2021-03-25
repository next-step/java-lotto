package lotto.view;

import lotto.controller.dto.PurchaseLottoAutoResponse;

import java.util.List;

public class ResultView {
    public void printPurchaseList(PurchaseLottoAutoResponse response) {
        System.out.println(response.getPurchaseCount() + " 개를 구매했습니다.");
        printLottoNumberList(response.getLottoNumberList());
    }

    private void printLottoNumberList(List<String> lottoNumberList) {
        for (String lottoNumbers : lottoNumberList) {
            System.out.println(lottoNumbers);
        }
    }

}
