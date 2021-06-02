package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<LottoNumbers> lottos;

    public Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottos = lottoNumbers;
    }

    public Lottos(List<LottoNumbers> manualLottoNumbers, List<LottoNumbers> autoLottoNumbers) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(manualLottoNumbers);
        lottoNumbers.addAll(autoLottoNumbers);
        this.lottos = lottoNumbers;
    }

    public List<LottoNumbers> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
