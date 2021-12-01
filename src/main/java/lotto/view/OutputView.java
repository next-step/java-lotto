package lotto.view;

import lotto.domain.LottoGameCount;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.utils.Rank;

import java.util.Map;

import static lotto.utils.Constants.*;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    private OutputView() {

    }

    public static void drawLottoGameCount(LottoGameCount lottoGameCount) {
        System.out.println();
        sb.append(MSG_MANUAL_COUNT);
        sb.append(lottoGameCount.getLottoManualCount());
        sb.append(MSG_AUTO_COUNT);
        sb.append(lottoGameCount.getLottoAutoCount());
        sb.append(MSG_LOTTO_COUNT);
        System.out.println(sb);
        sb.setLength(NUMBER_ZERO);
    }

    public static void drawPurchasedLottos(Lottos lottos) {
        lottos.getLottoGames().forEach(lottoGame ->
                System.out.println(lottoGame.getLottoNumbers().getLottoNumbers()));
        System.out.println();
    }

    public static void drawResultWinLotto(LottoGameCount lottoGameCount, LottoResult lottoResult) {
        System.out.println();
        System.out.println(MSG_WINNING_STATISTICS);
        System.out.println(MSG_DASH_TEN);
        lottoResult.getRanks()
                .entrySet()
                .stream()
                .filter(rank -> !rank.getKey().equals(Rank.MISS))
                .forEach(rank -> drawLottoResult(rank));

        drawTotalReward(lottoGameCount, lottoResult);
    }

    private static void drawLottoResult(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        sb.append(rank.getCountOfMatch() + MSG_NUMBER_SAME);
        if (rank == Rank.SECOND) {
            sb.append(COMMA);
            sb.append(MSG_BONUS_SAME);
        }
        sb.append(MSG_BRACKET);
        sb.append(rank.getWinningMoney());
        sb.append(MSG_WON_BRACKET);
        sb.append(entry.getValue());
        sb.append(MSG_NUMBER);
        System.out.println(sb);
        sb.setLength(NUMBER_ZERO);
    }


    public static void drawTotalReward(LottoGameCount lottoGameCount, LottoResult lottoResult) {
        sb.append(MSG_TOTAL_YIELD);
        sb.append(lottoResult.calculateYield(lottoGameCount));
        sb.append(MSG_IS);
        System.out.println(sb);
    }
}
