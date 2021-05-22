package lotto.domain;

public final class Bank {
    private final Lotto answerLotto;
    
    public Bank(Lotto answerLotto) {
        this.answerLotto = answerLotto;
    }

    public LottoResult matchLotto(Lotto unidentifiedLotto) {
        return LottoResult.findByMatchCount(answerLotto.matchCount(unidentifiedLotto));
    }
}
