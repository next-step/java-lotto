package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<List<Integer>> lottoNumbers = new ArrayList<>();

    public Lotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.getNumber());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
