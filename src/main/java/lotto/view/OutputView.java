package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.LottoNumber;

public class OutputView {

    public void printPurchasedLotto(Lotto lotto) {
        System.out.println(lotto.getLottoSize() + "개 구매했습니다.");

        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            System.out.println("[" + printLottoNumber(lottoNumber) + "]");
        }
    }

    private String printLottoNumber(LottoNumber lotto) {
        List<Integer> numbers = lotto.getNumbers();
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer number : numbers) {
            stringBuilder.append(number + ", ");
        }

        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length() - 1, "");
        return stringBuilder.toString();
    }

    public void printStatisticLotto(Map<Prize, Integer> rankMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRank(rankMap);
    }

    public void printYield(double yield) {
        System.out.println(
                "총 수익률은 " + String.format("%.3f", yield) +
                "입니다.");
    }

    private void printRank(Map<Prize, Integer> rankMap) {
        Arrays.stream(Prize.values()).filter(v -> v.getWinningCount() > 0).sorted(
                Comparator.comparing(Prize::getWinningCount)).forEach(p -> {
            System.out.println(p.getWinningCount() + "개 일치 (" + p.getPrizeMoney() + "원) - " +
                               rankMap.get(p) + "개");
        });
    }
}
