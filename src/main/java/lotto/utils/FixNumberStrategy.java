package lotto.utils;

import java.util.List;

public class FixNumberStrategy implements NumberStrategy {

    private final List<Integer> lottoNumbers;

    public FixNumberStrategy(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

}
