package lotto.domain;

import lotto.domain.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    
    public List<Integer> generate() {
        List<Integer> lotto = createLottoNumbers();
        Collections.sort(lotto);
        return lotto;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lotto = new ArrayList<>(6);
        while (lotto.size() < 6) {
            addLottoNumber(lotto);
        }
        return lotto;
    }

    private void addLottoNumber(List<Integer> lotto) {
        int generatedNumber = LottoNumberGenerator.generate();
        if (!lotto.contains(generatedNumber)) {
            lotto.add(generatedNumber);
        }
    }

}