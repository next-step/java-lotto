package step2.view;

import step2.domain.model.Lotto.Lotto;
import step2.domain.model.Lotto.Lottos;
import step2.domain.model.WinningAmountByRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static void outPut(int result) {
        System.out.println(String.format("%d개를 구매하였습니다.", result));
    }

    public static void outPutLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(String.format("[%s]", convertLottoNumbersToString(lotto)));
        }
    }

    public static void outPutProfit(double Profit, Map<String, Integer> winningCount) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.FOURTH.getRank(),
                WinningAmountByRank.FOURTH.getAmount(), winningCount.getOrDefault(WinningAmountByRank.FOURTH.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.THIRD.getRank(),
                WinningAmountByRank.THIRD.getAmount(), winningCount.getOrDefault(WinningAmountByRank.THIRD.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.SECOND.getRank(),
                WinningAmountByRank.SECOND.getAmount(), winningCount.getOrDefault(WinningAmountByRank.SECOND.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.FIRST.getRank(),
                WinningAmountByRank.FIRST.getAmount(), winningCount.getOrDefault(WinningAmountByRank.FIRST.getKey(), 0)));
        System.out.println(String.format("수익률 %f.", Profit));
    }

    private static String convertLottoNumbersToString(Lotto lotto) {
        return  lotto.getNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(", "));
    }
}
