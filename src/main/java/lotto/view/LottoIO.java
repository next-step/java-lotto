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
    }
}