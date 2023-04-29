package lotto.view;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import lotto.domain.enums.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int LOTTO_AMOUNT = 1000;

    public static List<LottoNumbers> printLottoNumbers(int purchaseAmount) {
        int purchaseCount = purchaseAmount / LOTTO_AMOUNT;
        if (purchaseCount == 0) {
            throw new IllegalArgumentException("구매금액이 1000원 미만입니다.");
        }

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= purchaseCount; i++) {
            LottoNumbers generate = LottoGenerator.generate();
            lottoNumbers.add(generate);
            System.out.println(generate);
        }
        System.out.println(purchaseCount + "개를 구매했습니다.");
        return lottoNumbers;
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
            int prize = rank.getWinningMoney();
            int count = map.getOrDefault(rank, 0);
            System.out.println(rank + "- " + count + "개");
            sum += prize * count;
        }

        System.out.println("총 수익률은 " + sum / purchaseAmount + "입니다.");
    }

    private ResultView() {}
}
