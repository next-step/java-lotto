package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<Integer> LOTTO_ALL_NUMBERS = createAllNumberOfLotto();
    static final int SINGLE_LOTTO_MONEY = 1_000;

    private final int lottoCounts;

    public LottoFactory(LottoMoney lottoMoney) {
        this.lottoCounts = lottoMoney.value() / SINGLE_LOTTO_MONEY;
    }

    public List<LottoNumbers> createLottoNumbersBundle() {
        return IntStream.range(0, lottoCounts)
                .mapToObj(index -> createLottoNumbers())
                .collect(Collectors.toList());
    }

    public int getLottoCounts() {
        return lottoCounts;
    }

    private static List<Integer> createAllNumberOfLotto() {
        return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                        .boxed()
                        .collect(Collectors.toList());
    }

    private static LottoNumbers createLottoNumbers() {
        Collections.shuffle(LOTTO_ALL_NUMBERS);
        List<LottoNumber> lottoNumbers = LOTTO_ALL_NUMBERS.subList(0, 6).stream()
                                                          .map(LottoNumber::of)
                                                          .collect(Collectors.toList());

        return LottoNumbers.from(lottoNumbers);
    }
}
