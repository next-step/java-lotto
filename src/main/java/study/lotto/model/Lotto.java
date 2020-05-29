package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<Integer> LOTTO_NUMBER_BASE = new ArrayList<>();

    private final List<Integer> lottoNumbers;

    static {
        for(int i=1; i<46; i++) {
            LOTTO_NUMBER_BASE.add(i);
        }
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generate() {
        Lotto lotto = new Lotto(generateLottoNumbers());
        Collections.sort(lotto.getLottoNumbers());

        return lotto;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private static List<Integer> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_BASE);

        return LOTTO_NUMBER_BASE.subList(0, 6);
    }

    public long compareToWinningNumbers(List<Integer> winningNumbers) {
        return lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
