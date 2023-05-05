package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_MAX;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_MIN;

public class LottoIssuer {

    private static final int BEGIN_INDEX = 0;
    private static List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            allNumbers.add(i);
        }
    }

    public static List<Lotto> issueLottos(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < lottoCount; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        Collections.shuffle(allNumbers);
        List<Integer> numbers = allNumbers.subList(BEGIN_INDEX, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
