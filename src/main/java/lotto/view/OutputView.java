package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.OutputData;

public class OutputView {
    private int lottoCnt = 0;

    public OutputView() {

    }

    public OutputView(int lottoCnt) {
        this.lottoCnt = lottoCnt;
    }

    public void printLottoCnt() {
        System.out.println(this.lottoCnt + "개를 구매했습니다.");
    }

    public void printPurchasedLotto(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.toString());
    }

    public void printLottoResult(OutputData inputOutputData) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치(5,000원)- " + inputOutputData.threeWin().number() + "개");
        System.out.println("4개 일치(50,000원)- " + inputOutputData.fourWin().number() + "개");
        System.out.println("5개 일치(1,500,000원)- " + inputOutputData.fiveWin().number() + "개");
        System.out.println("6개 일치(2,000,000,000원)- " + inputOutputData.sixWin().number() + "개");
    }

    public void printRate(OutputData outputData) {
        System.out.println("총 수익률은 " + outputData.calculateRate());
    }

}
