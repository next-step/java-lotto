package lottoauto;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winnigLotto;

    private WinningLotto(Lotto winningLottoNumbers) {
        this.winnigLotto = winningLottoNumbers;
    }

    public static WinningLotto from(String[] numbers) {
        return new WinningLotto(Lotto.from(numbers));
    }

    public Rating matchingCount(Lotto lottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            if(winnigLotto.contains(lottoNumber)) {
                count++;
            }
        }
        return Rating.from(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winnigLotto, that.winnigLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnigLotto);
    }
}
