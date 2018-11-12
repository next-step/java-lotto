package domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final boolean isAutoGame;

    public Lotto(LottoNumbers lottoNumbers, boolean isAutoGame) {
        this.lottoNumbers = lottoNumbers;
        this.isAutoGame = isAutoGame;
    }

    public boolean isAutoGame() {
        return isAutoGame;
    }

    public int match(WinningNumber winningNumber) {
        return lottoNumbers.match(winningNumber);
    }

    public boolean matchBonus(WinningNumber winningNumber) {
        return lottoNumbers.matchBonus(winningNumber);
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.toString() + "]";
    }
}
