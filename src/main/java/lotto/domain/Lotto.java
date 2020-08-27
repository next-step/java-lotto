package lotto.domain;

public class Lotto {
    private final int lottoCount;

    public Lotto(int lottoPrice) {
        this.lottoCount = lottoPrice / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
