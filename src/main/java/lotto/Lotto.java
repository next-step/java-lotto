package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public String toString() {
        return String.join(", ", String.valueOf(lottoNumbers));
    }
}
