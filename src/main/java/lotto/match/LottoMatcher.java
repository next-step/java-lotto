package lotto.match;

import lotto.domain.AnswerSheet;
import lotto.domain.Lotto;
import lotto.prize.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMatcher {

    private LottoMatcher() {
    }

    public static Map<LottoPrize, Long> matchLottoToPrize(List<Lotto> lottos, AnswerSheet answerSheet) {
        return lottos.stream()
                .map(lotto ->
                        LottoPrize.from(lotto.countMatchNumbers(answerSheet.getAnswerNumbers())
                                ,lotto.containsNumber(answerSheet.getBonusNumber())))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
