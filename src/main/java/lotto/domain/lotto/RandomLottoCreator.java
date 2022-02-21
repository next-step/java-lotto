package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoCreator implements LottoCreator {

    private final List<LottoNumber> numberData =
        IntStream.rangeClosed(LottoNumber.LOTTO_FIRST_NUMBER, LottoNumber.LOTTO_LAST_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public Lotto createLotto() {
        Collections.shuffle(numberData);
        return new Lotto(new ArrayList<>(numberData.subList(0, Lotto.LOTTO_NUMBERS_SIZE)));
    }
}
