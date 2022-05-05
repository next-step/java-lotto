package lotto.domain;

import lotto.exception.NotSupportInstanceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private static final List<LottoNumber> FULL_LOTTO_NUMBERS = fullLottoNumbers();

    private LottoStore() {
        throw new NotSupportInstanceException();
    }

    private static List<LottoNumber> fullLottoNumbers() {
        List<LottoNumber> fullLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            fullLottoNumbers.add(new LottoNumber(i));
        }
        return fullLottoNumbers;
    }

    private static LottoNumbers randomLottoNumbers() {
        List<LottoNumber> random = new ArrayList<>();
        Collections.shuffle(FULL_LOTTO_NUMBERS);
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBER_COUNT; i++) {
            random.add(FULL_LOTTO_NUMBERS.get(i));
        }
        return new LottoNumbers(random);
    }

    public static Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomLottoNumbers()));
        }
        return new Lottos(lottos);
    }
}
