package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoTicket.LOTTO_NUMBERS_COUNT;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private RandomLottoNumberStrategy() {
    }

    public static RandomLottoNumberStrategy create() {
        return new RandomLottoNumberStrategy();
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = initLottoNumbers();
        Collections.shuffle(lottoNumbers);
        Collections.sort(extractLottoNumbers(lottoNumbers));
        return lottoNumbers;
    }

    private List<Integer> extractLottoNumbers(List<Integer> numbers) {
        return numbers.subList(0, LOTTO_NUMBERS_COUNT);
    }

    private List<Integer> initLottoNumbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
