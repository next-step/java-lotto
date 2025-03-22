package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {

    public Lotto createLotto() {
        List<LottoNumber> allLottoNumbers = new ArrayList<>(LottoNumber.getAllNumbers());
        Collections.shuffle(allLottoNumbers);

        List<LottoNumber> lottoNumbers = allLottoNumbers
            .stream()
            .limit(Lotto.LOTTO_SIZE)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

}
