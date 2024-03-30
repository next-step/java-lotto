package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<LottoNumber> lottoNumbers;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void generateLottoNumbers(List<Integer> lottoNumber, int amount) {
        for (int i = 0; i < amount; i++) {
            LottoNumber newLottoNumber = new LottoNumber(lottoNumber);
            lottoNumbers.add(newLottoNumber);
        }
    }

    public void saveMatchResult(WinningLotto winningLotto, Match match) {
        this.lottoNumbers.forEach(iter -> {
            winningLotto.saveMatchInfo(iter, match);
        });
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public void generateManualLottoNumbers(ManualLottoGroup manualLottoGroup) {
        List<LottoNumber> lottoNumbers = manualLottoGroup.convertToLottoNumbers();
        this.lottoNumbers.addAll(lottoNumbers);
    }
}
