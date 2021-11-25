package lotto.view;

import lotto.WinningLotto;
import lotto.Prize;
import lotto.Wallet;

import static lotto.Prize.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int BASE_RATE = 1;

    public void showStatus(int money, Wallet wallet, WinningLotto winningLotto) {
        System.out.println("당첨 통계\n---------\n");

        final List<Prize> targetStatus = Arrays.stream(values())
                .filter(prize -> prize.compareTo(SIXTH) > 0)
                .collect(Collectors.toList());

        showStatistics(wallet, winningLotto, targetStatus);
        showRate(money, wallet, winningLotto, targetStatus);
    }

    private void showRate(int money, Wallet wallet, WinningLotto winningLotto, List<Prize> targetStatus) {
        double totalPrize = 0;
        for (Prize status : targetStatus) {
            totalPrize += wallet.lottoResultByPrize(winningLotto, status) * status.getPrize();
        }

        double rate = totalPrize / money;

        if (rate >= BASE_RATE) {
            System.out.println("총 수익률은 " + rate +"입니다. (이익)");
            return;
        }

        System.out.println("총 수익률은 " + rate +"입니다. (손해)");
    }

    private void showStatistics(Wallet wallet, WinningLotto winningLotto, List<Prize> targetStatus) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Prize status : targetStatus) {
            stringBuilder.append(status.getMatchCount());
            stringBuilder.append("개 일치");
            hasBonus(stringBuilder, status);
            stringBuilder.append("(");
            stringBuilder.append(status.getPrize());
            stringBuilder.append(") - ");
            stringBuilder.append(wallet.lottoResultByPrize(winningLotto, status));
            stringBuilder.append("개");
            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder);
    }

    private void hasBonus(StringBuilder stringBuilder, Prize status) {
        if (status == SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
    }
}
