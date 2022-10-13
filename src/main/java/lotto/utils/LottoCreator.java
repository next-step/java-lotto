package lotto.utils;

import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoNumber.initializeLottoNumbers;

public class LottoCreator {

    private static final int LOTTO_PRICE = 1000;

    private LottoCreator() {
        throw new AssertionError();
    }

    private static Lotto createLotto() {
        List<LottoNumber> lottoNumberList = initializeLottoNumbers();
        Collections.shuffle(lottoNumberList);

        List<LottoNumber> createdLotto = lottoNumberList.subList(0, 6);
        Collections.sort(createdLotto);

        return new Lotto(createdLotto);
    }

    public static Lotteries getLotteries(int purchasedAmount) {
        List<Lotto> lotteries = IntStream.rangeClosed(1, purchasedAmount / LOTTO_PRICE)
                .mapToObj(v -> createLotto())
                .collect(Collectors.toList());

        return new Lotteries(lotteries);
    }
}
