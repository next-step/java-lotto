package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static List<Lotto> manualGenerateLottos(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static List<Lotto> autoGenerateLottos(int count) {
        List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = autoGenerateLotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto autoGenerateLotto(List<LottoNumber> lottoNumbersCopy) {
        Collections.shuffle(lottoNumbersCopy);
        List<LottoNumber> lottoNumbers = lottoNumbersCopy.subList(0, 6);
        return new Lotto(lottoNumbers);
    }
}
