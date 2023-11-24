package lotto.domain;

public class Ticket {
    public static final int PRICE = 1000;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    public Ticket() {
    }

    public Ticket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long match(LottoNumbers winneingLottoNumbers) {
        return this.lottoNumbers.compareNumbers(winneingLottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
