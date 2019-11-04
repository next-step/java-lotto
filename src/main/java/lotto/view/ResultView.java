package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinnerType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printBuyTicketNumber(int number) {
        System.out.println(String.format("%s개를 구매했습니다.", number));
    }

    public static void printBuyLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(makeLottoNumberFormat(lotto.getNumbers()));
        }
        System.out.println();
    }

    private static String makeLottoNumberFormat(List<Integer> numbers) {
        String number = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", number);
    }

    public static void printWinnerStats(Map<WinnerType, Integer> winnerStats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------------------------");
        for (WinnerType type : WinnerType.values()) {
            System.out.println(makeStatsFormat(type, winnerStats.getOrDefault(type, 0)));
        }
    }

    private static String makeStatsFormat(WinnerType type, int count) {
        return String.format("%s개 일치 (%s)원 - %s 개", type.getSameCount(), type.getPrize(), count);
    }

    public static void printYield(double yield) {
        System.out.println(String.format("총 수익률은 %s 입니다.", yield));
    }
}
