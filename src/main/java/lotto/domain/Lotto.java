package lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private Rank rank;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto rank(LottoNumbers winnerLottoNumbers) {
        this.rank = Rank.valueOf((int) this.lottoNumbers.getLottoNumberList()
                .stream()
                .filter(winnerLottoNumbers.getLottoNumberList()::contains)
                .count());
        return this;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public Rank getRank() {
        return this.rank;
    }
}
