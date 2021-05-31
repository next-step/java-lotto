package lotto.view;

import lotto.domain.LottoGames;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.dto.PurchaseMoney;

import static java.lang.String.format;


public class LottoOutputView {
    private static final String MESSAGE_PURCHASING_LOTTO_GAMES_RESULT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String MESSAGE_LOTTO_RESULT_HEADER = "당첨통계\n---------";
    private static final String MESSAGE_LOTTO_RESULT_BODY = "%d개 일치 (%d원)- %d개\n";
    private static final String MESSAGE_LOTTO_RESULT_SECOND_BODY = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String MESSAGE_LOTTO_PROFIT_RESULT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public void printLottoGamesSize(LottoGames autoLottoGames, LottoGames manualLottoGames) {
        System.out.println(format(MESSAGE_PURCHASING_LOTTO_GAMES_RESULT, manualLottoGames.size(), autoLottoGames.size()));
    }

    public void printLottoGame(LottoGames lottoGames) {
        for (int i = 0; i < lottoGames.size(); i++) {
            System.out.println(lottoGames.get(i));
        }
    }

    public void printPrizeStatistics(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        System.out.println();
        System.out.println(MESSAGE_LOTTO_RESULT_HEADER);
        System.out.println(printPrizeDetail(lottoResult));
        System.out.println(createProfitStaticResult(lottoResult, purchaseMoney));
    }

    private String printPrizeDetail(LottoResult lottoResult) {
        StringBuilder prizeDetail = new StringBuilder();

        for (int i = Rank.values().length - 1; i >= 0; i--) {
            prizeDetail.append(createEachPrizeDetail(lottoResult, Rank.values()[i]));
        }

        prizeDetail.substring(0, prizeDetail.length() - 1);
        return prizeDetail.toString();
    }

    private String createEachPrizeDetail(LottoResult lottoResult, Rank rank) {
        if (rank == Rank.MISS) {
            return "";
        } else if (rank == Rank.SECOND) {
            return format(MESSAGE_LOTTO_RESULT_SECOND_BODY, rank.getMatchCount(), rank.getPrize(), lottoResult.get(rank));
        }

        return format(MESSAGE_LOTTO_RESULT_BODY, rank.getMatchCount(), rank.getPrize(), lottoResult.get(rank));
    }

    private String createProfitStaticResult(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        return format(MESSAGE_LOTTO_PROFIT_RESULT, lottoResult.getProfit(purchaseMoney));
    }
}
