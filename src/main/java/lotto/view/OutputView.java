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

    public void printStatisticLottoWithBonus(Map<Prize, Integer> rankMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankWithBonus(rankMap);
    }

    public void printYield(double yield) {
        System.out.println(
                "총 수익률은 " + String.format("%.3f", yield) +
                "입니다.");
    }

    private void printRankWithBonus(Map<Prize, Integer> rankMap) {
        Arrays.stream(Prize.values())
              .filter(v -> v.getWinningCount() > 0)
              .sorted(Comparator.comparing(Prize::getPrizeMoney))
              .forEach(p -> {
                  System.out.println(printRank(rankMap, p));
              });
    }

    private String printRank(Map<Prize, Integer> rankMap, Prize prize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prize.getWinningCount());
        stringBuilder.append("개 일치");
        stringBuilder.append(isBonusRank(prize) + " (");
        stringBuilder.append(prize.getPrizeMoney() + "원) - ");
        stringBuilder.append(rankMap.get(prize) + "개");
        return stringBuilder.toString();
    }

    private String isBonusRank(Prize prize) {
        if (prize == Prize.RANK_2TH_WITH_BONUS) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
