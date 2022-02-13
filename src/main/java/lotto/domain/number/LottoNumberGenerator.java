package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.user.UserLotto;

public class LottoNumberGenerator {

    private static final List<LottoNumber> numberData =
        IntStream.rangeClosed(LottoNumber.LOTTO_FIRST_NUMBER, LottoNumber.LOTTO_LAST_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numberData);
        return new ArrayList<>(numberData.subList(0, UserLotto.LOTTO_NUMBERS_SIZE));
    }
}
