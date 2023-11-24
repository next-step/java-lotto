package lotto.view;

import lotto.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.enums.Rank;

import java.util.Map;

public class LottoResultView {
    public static void printLotto(Lotto lotto) {
        for (LottoNumbers numbers : lotto.getLottoNumbers()) {
            System.out.println(numbers);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨결과\n================================");
        for (Map.Entry<Rank, Integer> entry : lottoResult.getWinningCountPerRank().entrySet()) {
            System.out.printf("%d개 일치(%d원) - %d개%n", entry.getKey().getMatchCount(), entry.getKey().getPrizeAmount(), entry.getValue());
        }
        System.out.printf("총 수익률은 %.2f 입니다.%n", lottoResult.getRateOfReturn());
    }
}
