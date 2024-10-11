package lotto.domain;

public class LottoMatcher {

    public static int match(Lotto userNumbers, Lotto winningNumbers) {
        return winningNumbers.match(userNumbers.getLottoNumbers());
    }
}
