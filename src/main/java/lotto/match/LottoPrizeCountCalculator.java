package lotto.match;

import lotto.domain.AnswerSheet;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.prize.LottoPrize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoPrizeCountCalculator {

    private final List<Lotto> lottoList;
    private final Lotto answerSheet;
    private final LottoNumber bonusNumber;

    public LottoPrizeCountCalculator(LottoList lottoList, AnswerSheet answerSheet) {
        this.lottoList = lottoList.getLottoList();
        this.answerSheet = answerSheet.getAnswerLotto();
        this.bonusNumber = answerSheet.getBonusNumber();
    }

    private Map<LottoPrize, Long> getMatchResult() {

        return lottoList
                .stream()
                .map(lotto -> LottoPrize.from(lotto.countMatchNumbers(answerSheet),lotto.containsNumber(bonusNumber)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<LottoPrizeCount> getLottoPrizeCount() {

        Map<LottoPrize, Long> matchMap = getMatchResult();

        return Arrays.stream(LottoPrize.values())
                .map(entry -> new LottoPrizeCount(entry, matchMap.getOrDefault(entry,0L)))
                .collect(Collectors.toList());
    }
}
