package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<Match> matches;

    private LottoResult(List<Match> matches) {
        this.matches = matches;
    }

    public static LottoResult of(List<Integer> winningNumbers, List<Lotto> lottos){
        validationCheck(winningNumbers);
        return new LottoResult(getMatches(winningNumbers, lottos));
    }

    private static void validationCheck(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6자여야 합니다.");
        }
    }

    private static List<Match> getMatches(List<Integer> winningNumbers, List<Lotto> lottos) {
        return lottos.stream()
                    .map(lotto -> Match.findByMatchCount(lotto.matchCount(winningNumbers)))
                    .filter(match -> !match.equals(Match.NONE))
                    .collect(Collectors.toList());
    }

    public List<Match> getMatches() {
        return matches;
    }
}
