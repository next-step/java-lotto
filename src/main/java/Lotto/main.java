package Lotto;

import Lotto.domain.LottoGame;
import Lotto.view.LottoView;

public class main {
    public static void main(String[] args) {
        new LottoView(LottoGame.start());
    }
}
