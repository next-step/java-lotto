package lotto.domain;

public class ManualLottoGenerator implements LottoGenerator {
    private final String rowLine;

    public ManualLottoGenerator(String rowLine) {
        this.rowLine = rowLine;
    }

    public static ManualLottoGenerator of(String rowLine) {
        return new ManualLottoGenerator(rowLine);
    }

    @Override
    public Lotto generate() {
        return Lotto.of(rowLine);
    }
}
