package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static Lotto createAuto() {
        List<LottoNumber> allLottoNumbers = new ArrayList<>(LottoNumber.getAllNumbers());
        Collections.shuffle(allLottoNumbers);

        List<LottoNumber> lottoNumbers = allLottoNumbers
            .stream()
            .limit(Lotto.LOTTO_SIZE)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static Lotto createManual(Collection<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

}
