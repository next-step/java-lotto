package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lotto generateAutoLotto() {
        Collections.shuffle(LottoNumberList.lottoNumberList);
        Set<LottoNumber> lottoNumbers = LottoNumberList.lottoNumberList.stream()
                .limit(LottoConstants.NUMBER_COUNT_PER_GAME)
                .collect(Collectors.toSet());

        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    public Lotto generateManualLotto(String manualLottoStr) {
        return new Lotto(manualLottoStr);
    }
}
