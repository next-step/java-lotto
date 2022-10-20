package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoNumber.getCachedInitLottoNumbers;

public class LottoCreator {

    private static final int LOTTO_PRICE = 1000;

    private LottoCreator() {
        throw new AssertionError();
    }

    private static Lotto createLotto() {
        List<LottoNumber> lottoNumberList = getCachedInitLottoNumbers();
        Collections.shuffle(getCachedInitLottoNumbers());

        return new Lotto(lottoNumberList.subList(0, 6));
    }

    public static List<Lotto> createAutoLotto(int purchasedAmount) {
        return IntStream.rangeClosed(1, purchasedAmount / LOTTO_PRICE)
                .mapToObj(v -> createLotto())
                .collect(Collectors.toList());
    }
}
