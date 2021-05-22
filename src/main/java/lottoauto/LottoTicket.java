package lottoauto;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
