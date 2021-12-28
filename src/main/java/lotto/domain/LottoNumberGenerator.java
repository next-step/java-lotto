package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public static LottoNumbers generate() {
        List<LottoNumber> shuffled = new ArrayList<>(LottoNumber.LOTTO_NUMBERS);
        Collections.shuffle(shuffled);
        return LottoNumbers.from(shuffled.subList(0, LottoNumbers.SIZE).stream().sorted().collect(Collectors.toList()));
    }
}
