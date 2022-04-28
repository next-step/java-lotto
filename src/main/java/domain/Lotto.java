package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
