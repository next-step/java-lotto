package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    protected static void printLottoNumbers(Lottoes lottoes) {
        System.out.println("수동으로 " + lottoes.getManualLotto().size() + "장, 자동으로 " + lottoes.getAutoLotto().size() + "장을 구매했습니다.");

        for (LottoNumbers lottoNumbers : lottoes.getTotalLotto()) {
            List<Integer> numbers = lottoNumbers.getValue().stream()
                    .map(LottoNumber::getValue)
                    .collect(Collectors.toList());
            System.out.println(numbers.toString());
        }
        System.out.println();
    }

    protected static void printLottoGameResult(Map<Rank, Integer> ranks) {
        String first = "6개 일치 (2,000,000,000원) - " + ranks.get(Rank.FIRST);
        String second = "5개 일치, 보너스 볼 일치(30,000,000원) - " + ranks.get(Rank.SECOND);
        String third = "5개 일치 (1,500,000원) - " + ranks.get(Rank.THIRD);
        String fourth = "4개 일치 (50,000원) - " + ranks.get(Rank.FOURTH);
        String fifth = "3개 일치 (5,000원) - " + ranks.get(Rank.FIFTH);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(fifth);
        System.out.println(fourth);
        System.out.println(third);
        System.out.println(second);
        System.out.println(first);

    }

    protected static void printWinningStatistics(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
