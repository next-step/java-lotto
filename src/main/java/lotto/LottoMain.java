package lotto;

import java.util.List;
import lotto.controllers.LottoController;
import lotto.domains.Lotto;
import lotto.domains.LottoWinner;

public class LottoMain {
    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        LottoController lottoController = new LottoController();

        List<Lotto> lottoList = lottoController.purchaseLotto();
        LottoWinner winner = lottoController.drawLottery();

        lottoController.play(lottoList, winner);
    }
}
