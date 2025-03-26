package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final int minNumber;
    private final int maxNumber;
    private final int size;

    public LottoGenerator(int minNumber, int maxNumber, int size) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.size = size;
    }

    public List<Integer> generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = minNumber; i <= maxNumber; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, size);
    }
}
