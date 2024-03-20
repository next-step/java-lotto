package lotto;

import lotto.view.InputView;

public class LottoPlayer {

    private void play() {
        final int purchasePrice = InputView.purchasePrice();
    }

    public static void main(String[] args) {
        final LottoPlayer lottoPlayer = new LottoPlayer();
        lottoPlayer.play();
    }
}
