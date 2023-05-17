package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS_POOL;

    static {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            lottoNumbers.add(lottoNumber);
        }
        LOTTO_NUMBERS_POOL = Collections.unmodifiableList(lottoNumbers);
    }

    public static List<Lotto> generateLottos(int buyCount) {
        List<LottoNumber> poolCopy = new ArrayList<>(LOTTO_NUMBERS_POOL);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = generateLotto(poolCopy);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto generateLotto(List<LottoNumber> lottoNumbersPool) {
        Collections.shuffle(lottoNumbersPool);
        List<LottoNumber> lotto = lottoNumbersPool.subList(0, 6);
        return new Lotto(lotto);
    }
}
