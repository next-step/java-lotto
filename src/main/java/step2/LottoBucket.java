package step2;

import java.util.Objects;

public class LottoBucket {
    private final Lottoes lottoes;

    public LottoBucket() {
        this.lottoes = new Lottoes();
    }

    public void addLottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
        Lotto lotto = new Lotto(lottoNumberGenerator);

        this.lottoes.add(lotto);
    }

    public int size() {
        return lottoes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBucket that = (LottoBucket) o;
        return Objects.equals(lottoes, that.lottoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoes);
    }

    @Override
    public String toString() {
        return lottoes.toString();
    }
}
