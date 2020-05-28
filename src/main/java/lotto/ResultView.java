package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.Rank.*;

public class ResultView {

    private ResultView() {}

    private static final Stream<Rank> RESULT_VIEW_RANKS = Stream.of(First, Second, Third, Fourth);

    public static void printLottos(Lottos lottos) {
        System.out.println(String.format("%d개를 구입했습니다.", lottos.size()));

        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.getLotto(i));
        }
    }

    private static void printLotto(Lotto lotto) {
        List<String> numbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String numbersStr = String.join(",", numbers);
        System.out.println(String.format("[%s]", numbersStr));
    }

    public static void printResults(LottoResults results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

		RESULT_VIEW_RANKS.forEach(r -> {
			String msg = String.format("%d개 일치 (%d원)- %d개", r.getMatchedCount(), r.getPrizeMoney(), results.getCounts(r));
			System.out.println(msg);
		});

		System.out.println(String.format("총 수익률은 %.2f입니다.", results.getProfitRate()));
    }
}
