package lotto.view;

import lotto.controller.dto.PurchaseLottoAutoResponse;

import java.util.Arrays;

public class ResultView {
    public void printPurchaseList(PurchaseLottoAutoResponse response) {
        System.out.println(response.getPurchaseCount() + " 개를 구매했습니다.");
        printLottoNumberList(response.getLottoNumberList());
    }

    private void printLottoNumberList(int[][] lottoNumberList) {
        for (int[] ints : lottoNumberList) {
            printLottoNumber(ints);
        }
    }

    private void printLottoNumber(int[] lottoNumbers) {
        System.out.println(Arrays.toString(lottoNumbers));
    }
}
