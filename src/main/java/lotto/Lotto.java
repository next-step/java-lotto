package lotto;

import java.util.List;

public class Lotto {

    private final Numbers lottoNumbers;

    public Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = new Numbers(lottoNumbers);
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = new Numbers(lottoNumbers);
    }

    public int countMatch(Lotto other) {
        return lottoNumbers.countMatch(other.lottoNumbers);
    }

    public String toString() {
        return lottoNumbers.toString();
    }

}
