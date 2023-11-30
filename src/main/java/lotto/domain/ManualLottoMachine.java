package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine {
    public Lottos createLottos(List<List<Integer>> lottos) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (List<Integer> lotto : lottos) {
            manualLottos.add(createLotto(lotto));
        }
        return new Lottos(manualLottos);
    }

    private Lotto createLotto(List<Integer> lotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : lotto) {
            lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        }
        return new Lotto(lottoNumbers);
    }
}
