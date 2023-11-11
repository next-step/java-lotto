package me.namuhuchutong.lotto;

public class LottoSeller {

    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public void sellLotto(int amount) {
        validateAmount(amount);
        int times = amount / 1000;
    }

    private void validateAmount(int amount) {
        if (amount / 1000 == 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }
    }
}
