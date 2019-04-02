package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printLottos(List<Lotto> lottos, int quantity, int manualQuantity) {
        System.out.println();
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 " + (quantity - manualQuantity) + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<WinningType> winningTypes = Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.getMatchCount() > 0)
                .sorted((a, b) -> Integer.compare(b.getRank(), a.getRank()))
                .collect(Collectors.toList());
        for(WinningType winningType : winningTypes) {
            System.out.println(printBonus(lottoResult, winningType));
        }
    }

    public void printEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private String printBonus(LottoResult lottoResult, WinningType winningType) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(winningType.getMatchCount());
        buffer.append("개 일치");
        if(winningType.isMatchBonus()) {
            buffer.append(", 보너스 볼 일치");
        }
        buffer.append(" (");
        buffer.append(winningType.getPrize());
        buffer.append(") - ");
        buffer.append(lottoResult.matchLottoWithBonusCount(winningType.getMatchCount(), winningType.isMatchBonus()));
        return buffer.toString();
    }
}
