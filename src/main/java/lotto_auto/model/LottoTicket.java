package lotto_auto.model;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = LottoNumbers.generate();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
