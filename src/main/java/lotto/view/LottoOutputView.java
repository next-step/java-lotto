package lotto.view;

import lotto.domain.LottoGames;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.dto.PurchaseMoney;

import static java.lang.String.format;


public class LottoOutputView {
    private static final String MESSAGE_LOTTO_GAMES_SIZE_ = "%d개를 구매했습니다.";
    private static final String MESSAGE_LOTTO_RESULT_HEADER = "당첨통계\n---------";
    private static final String MESSAGE_LOTTO_RESULT_BODY = "%d개 일치 (%d원)- %d개\n";
    private static final String MESSAGE_LOTTO_PROFIT_RESULT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public void printLottoGamesSize(LottoGames lottoGames) {
        System.out.println(format(MESSAGE_LOTTO_GAMES_SIZE_, lottoGames.size()));
    }

    public void printLottoGame(LottoGames lottoGames) {
        for (int i = 0; i < lottoGames.size(); i++) {
            System.out.println(lottoGames.get(i));
        }
    }

    public void printPrizeStatics(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        System.out.println();
        System.out.println(MESSAGE_LOTTO_RESULT_HEADER);
        System.out.println(printPrizeDetail(lottoResult));
        System.out.println(createProfitStaticResult(lottoResult, purchaseMoney));
    }

    private String printPrizeDetail(LottoResult lottoResult) {
        StringBuilder prizeDetail = new StringBuilder();
        for (Rank eachRank : Rank.values()) {
            prizeDetail.append(createEachPrizeDetail(lottoResult, eachRank));
        }
        prizeDetail.substring(0, prizeDetail.length() - 1);
        return prizeDetail.toString();
    }

    private String createEachPrizeDetail(LottoResult lottoResult, Rank rank) {
        if (rank == Rank.MISS) {
            return "";
        }

        return format(MESSAGE_LOTTO_RESULT_BODY, rank.getMatchCount(), rank.getPrize(), lottoResult.get(rank));
    }

    private String createProfitStaticResult(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        return format(MESSAGE_LOTTO_PROFIT_RESULT, lottoResult.getProfit(purchaseMoney));
    }
}
