package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMatcher {

    private LottoMatcher() {
    }

    public static Map<LottoPrize, Long> matchLottoToPrize(List<Lotto> lottos, List<Integer> answerSheet) {
        return lottos.stream()
                .map(lotto -> lotto.countMatchNumbers(answerSheet))
                .map(LottoPrize::from)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
