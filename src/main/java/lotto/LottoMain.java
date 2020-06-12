package lotto;

import lotto.controller.LottoPages;
import lotto.view.LottoInput;
import lotto.view.StandardInputView;
import lotto.view.StandardOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInput input = new StandardInputView();
        LottoPages pages = new LottoPages(input.getPurchacePrice());
        StandardOutputView outputView = new StandardOutputView();
        outputView.printBoughtLotto(pages);
        int[] winner = input.getWinnerNumber();
        outputView.printStat(pages, winner);
    }
}
