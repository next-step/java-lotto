package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class LottoTicket {

    private static final int INITIAL_MATCH_COUNT = 0;

    private final List<LottoNumbers> lottoNumbersList;

    private LottoTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = Objects.requireNonNull(lottoNumbersList);
    }

    public static LottoTicket of(List<LottoNumbers> lottoNumbersList) {
        return new LottoTicket(lottoNumbersList);
    }

    public void foreach(Consumer<LottoNumbers> action) {
        lottoNumbersList.forEach(action);
    }

    public MatchResult match(LottoNumbers winningLottoNumbers) {
        Map<MatchCount, Integer> matchesTotalMap = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            MatchCount matchCount = lottoNumbers.match(winningLottoNumbers);
            int count = matchesTotalMap.getOrDefault(matchCount, INITIAL_MATCH_COUNT);
            matchesTotalMap.put(matchCount, ++count);
        }
        return MatchResult.of(matchesTotalMap);
    }
}
