package lotto.game;

public class Game {

    private final LottoNumbers lottoNumbers;

    public Game(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank win(LottoNumbers lottoNumbers) {
        int matchCount = this.lottoNumbers.matchCount(lottoNumbers);
        return Rank.of(matchCount);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
