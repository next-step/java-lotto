package lotto.domain;

public class LottoTicket {

    public static final int PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public static LottoTicket autoTicket() {
        return new LottoTicket(LottoNumbers.generate());
    }

    private LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers lottoNumbers() {
        return this.lottoNumbers;
    }
}
