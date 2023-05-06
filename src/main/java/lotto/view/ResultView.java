package lotto.view;

import lotto.domain.LottoGame;

import java.util.List;

public class ResultView {

    private static String RESULT_MESSAGE = "개를 구매했습니다.";
    private static String RESULT_GAME = "당첨 통계";
    private static String BREAK_LINE = "------";

    public ResultView() {}

    public void resultOfBuyLotto(int gameCount) {
        System.out.println(gameCount + RESULT_MESSAGE);
    }

    public void resultOfLottoGameList(List<LottoGame> lottoGames) {

        for(LottoGame lotto : lottoGames) {
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    public void resultGame() {
        System.out.println(RESULT_GAME);
        System.out.println(BREAK_LINE);
    }
}
