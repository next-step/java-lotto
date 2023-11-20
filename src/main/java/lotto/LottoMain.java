package lotto;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

import java.util.Arrays;

public class LottoMain {
    public static void main(String[] args) {
        Integer number = InputView.start();
        LottoTicket lottoTicket = new LottoTicket(number);
    }
}
