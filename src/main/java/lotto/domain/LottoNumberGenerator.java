package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for(int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }

        return lottoNumbers;
    }
}