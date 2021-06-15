package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoesCreator {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    public static final int FIRST_NUMBERS = 1;
    public static final int LAST_NUMBERS = 45;

    static {
        for (int i = FIRST_NUMBERS; i < LAST_NUMBERS; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static Lottoes generateLottoes(int lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoes.add(generateLotto());
        }
        return new Lottoes(lottoes);
    }

    private static Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> lottoNumbers = LOTTO_NUMBERS.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
