package lotto.domain;

public class ManualLottoGenerator implements LottoGenerator {

    private final String lottoPaper;

    public ManualLottoGenerator(String lottoPaper) {
        this.lottoPaper = lottoPaper;
    }

    @Override
    public Lotto publish() {
        return Lotto.from(this.lottoPaper);
    }
}
