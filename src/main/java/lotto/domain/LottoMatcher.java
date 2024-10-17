package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final List<Integer> winningNumbers;

    public LottoMatcher(LottoGenerator lottoGenerator, String winningNumbers) {
        this.winningNumbers = lottoGenerator.parseWinningNumbers(winningNumbers);
    }

    public List<Integer> matchLottoNumber(List<Lotto> userLottoList) {
        return userLottoList.stream()
                .map(userLotto -> userLotto.countMatches(winningNumbers))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LottoMatcher{" +
                "winningNumbers=" + winningNumbers +
                '}';
    }
}
