package util;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoResult;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    private LottoManager() {
        throw new IllegalStateException("Utility class");
    }

    public static Lotto createLotto() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return new Lotto(allLottoNumbers.stream()
                .limit(Lotto.needLottoNumberCount.value())
                .collect(Collectors.toList()));
    }
}
