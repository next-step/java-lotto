package lotto;

public final class LottoService {

    private final Lottos lottos;

    public LottoService(final int money, final NumbersGenerator numbersGenerator) {
        this.lottos = new Lottos(money, numbersGenerator);
    }

    public Lottos getLottos() {
        return this.lottos;
    }
}
