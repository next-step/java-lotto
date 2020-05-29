package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public static Lotto generate() {
        return new Lotto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
