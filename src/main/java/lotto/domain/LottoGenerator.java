package lotto.domain;

import java.util.*;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int count) {
        List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto(lottoNumbers);
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
