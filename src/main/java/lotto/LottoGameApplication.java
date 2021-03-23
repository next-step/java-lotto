package lotto;

import lotto.domain.HitResults;
import lotto.domain.LottoGames;
import lotto.domain.Stats;
import lotto.view.InputView;
import lotto.view.LottoGamesView;
import lotto.view.LottoStatsView;

public class LottoGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPayMoney("구입금액을 입력해 주세요.");

        LottoGames lottoGames = new LottoGames(inputView.getPayMoney());
        lottoGames.makeNumbers();

        LottoGamesView lottoGamesView = new LottoGamesView(lottoGames);
        lottoGamesView.printLottoGamesNumber();

        inputView.inputHitNumbers("지난 주 당첨 번호를 입력해 주세요.");
        HitResults hitResults = lottoGames.result(inputView.getWinNumbers());
        Stats stats = new Stats(hitResults);

        LottoStatsView lottoStatsView = new LottoStatsView(stats);
        lottoStatsView.printLottoResult();
    }
}
