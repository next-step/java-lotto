package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int INITIAL_MATCH_COUNT = 0;
    private static final String NEW_LINE = System.getProperty("line.separator");

    private final List<LottoNumbers> lottoNumbersList;

    private LottoTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = Objects.requireNonNull(lottoNumbersList);
    }

    public static LottoTicket of(List<LottoNumbers> lottoNumbersList) {
        return new LottoTicket(lottoNumbersList);
    }

    public MatchResult match(WinningLottoNumbers winningLottoNumbers) {
        Map<Rank, Integer> matchesTotalMap = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            Rank rank = winningLottoNumbers.match(lottoNumbers);
            int count = matchesTotalMap.getOrDefault(rank, INITIAL_MATCH_COUNT);
            matchesTotalMap.put(rank, ++count);
        }
        return MatchResult.of(matchesTotalMap);
    }

    @Override
    public String toString() {
        return lottoNumbersList.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining(NEW_LINE));
    }
}
