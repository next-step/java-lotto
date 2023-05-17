package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final Set<LottoNumber> LOTTO_NUMBERS;

    static {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1; i <= 45; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            lottoNumbers.add(lottoNumber);
        }
        LOTTO_NUMBERS = Collections.unmodifiableSet(lottoNumbers);
    }

    public static List<Lotto> generateLottos(int count) {
        List<LottoNumber> lottoNumbersCopy = new ArrayList<>(LOTTO_NUMBERS);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto(lottoNumbersCopy);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto generateLotto(List<LottoNumber> lottoNumbersCopy) {
        Collections.shuffle(lottoNumbersCopy);
        List<LottoNumber> lottoNumbers = lottoNumbersCopy.subList(0, 6);
        return new Lotto(lottoNumbers);
    }
}
