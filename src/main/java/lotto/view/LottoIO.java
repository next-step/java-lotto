package lotto.view;

import lotto.domain.LottoResult;

public class LottoIO implements LottoInputInterface, LottoOutputInterface {
    @Override
    public int getNumOfPurchased() {
        return InputView.promptInt("구입금액을 입력해 주세요.");
    }

    @Override
    public String getWinnerNumbers() {
        return InputView.promptString("지난 주 당첨 번호를 입력해주세요.");
    }

    @Override
    public void printResult(LottoResult result) {
        println("당첨 통계");
        println("---------");
        println(result.getResultOf(3));
        println(result.getResultOf(4));
        println(result.getResultOf(5));
        println(result.getResultOf(6));
        println("총 수익률은 " + result.getProfitRate() + "입니다.");
    }

    private void println(String message) {
        System.out.println(message);
    }
}