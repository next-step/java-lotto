package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>(6);
        while (lotto.size() < 6) {
            addLottoNumber(lotto);
        }
        return lotto;
    }

    private void addLottoNumber(List<Integer> lotto) {
        int generatedNumber = lottoNumberGenerator.generate();
        if (!lotto.contains(generatedNumber)) {
            lotto.add(generatedNumber);
        }
    }

}