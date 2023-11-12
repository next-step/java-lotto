package me.namuhuchutong.lotto;

public class LottoSeller {

    private final NumberGenerator generator;
    private Lotto lotto;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoResult sellLotto(int amount, Numbers userInput) {
        validateAmount(amount);
        int times = amount / 1000;
        lotto = Lotto.create(times, generator);
        return lotto.getMatchNumbers(userInput);
    }

    private void validateAmount(int amount) {
        if (amount / 1000 == 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }
    }
}
