import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private List<Integer> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++) {
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
