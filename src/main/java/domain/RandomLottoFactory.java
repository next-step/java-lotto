package domain;

public class RandomLottoFactory implements LottoFactory {

    @Override
    public Lotto create() {
        return Lotto.randomLotto();
    }
}
