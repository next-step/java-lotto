import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private List<Integer> lottoNumbers;
    private static final int LOTTO_MAX_NUMBER = 45;

    public LottoGenerator() {
        this.lottoNumbers = new ArrayList<>(LOTTO_MAX_NUMBER);
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> createNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(selectedNumbers);
        return new ArrayList<>(selectedNumbers);
    }
}
