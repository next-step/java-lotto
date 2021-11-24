package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.utils.Constants.NUMBER_ZERO;

public class Lottoes {
    private List<LottoNumbers> lottoNumbers;

    public Lottoes() {
        this.lottoNumbers = new ArrayList<>();
    }

    public Lottoes(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void makeLottoes(LottoGameCount lottoGameCount) {
        for (int i = NUMBER_ZERO; i < lottoGameCount.getLottoGameCount(); i++) {
            lottoNumbers.add(new LottoNumbers().createAutoLottoNumbers());
        }
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottos = (Lottoes) o;
        return Objects.equals(lottoNumbers, lottos.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }


}
