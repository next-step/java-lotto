package lotto;

public final class LottoService {

    private final Lottos lottos;
    private final int change;

    public LottoService(final int money, final NumbersGenerator numbersGenerator) {
        this.lottos = new Lottos(money, numbersGenerator);
        this.change = money % 1_000;
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public int getChange() {
        return this.change;
    }
}
