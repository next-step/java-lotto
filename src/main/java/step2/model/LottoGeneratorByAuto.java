package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorByAuto implements LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoGeneratorByAuto() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }
    @Override
    public Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, LOTTO_SIZE));
    }
}
