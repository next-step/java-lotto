package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.LottoApplication.LOTTO_AMOUNT;

public class ResultView {

    public static void printCountInfo(int manualCount, int autoCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public static void printLottoResult(List<LottoNumbers> lottoNumbers, WinnerNumbers winnerNumbers) {
        System.out.println("당첨 통계");
        Map<Rank, Integer> map = new HashMap<>();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            Rank rank = winnerNumbers.match(lottoNumber);
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        long purchaseAmount = lottoNumbers.size() * LOTTO_AMOUNT;
        long sum = 0;
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            long prize = rank.getWinningMoney();
            long count = map.getOrDefault(rank, 0);
            System.out.println(rank + "- " + count + "개");
            sum += prize * count;
        }

        System.out.println("총 수익률은 " + sum / purchaseAmount + "입니다.");
    }

    private ResultView() {}
}
