package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.number.LottoBalls.*;
import static lotto.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.number.LottoNumber.MIN_LOTTO_NUMBER;


public class AutoLottoNumberStrategy implements LottoNumberStrategy {

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = initLottoNumbers();
        Collections.shuffle(lottoNumbers);

        List<Integer> winningLottoNumbers = extractLottoNumbers(lottoNumbers);
        Collections.sort(winningLottoNumbers);
        return winningLottoNumbers;
    }

    private List<Integer> extractLottoNumbers(List<Integer> numbers) {
        return numbers.subList(0, NUMBER_OF_BALLS);
    }

    private List<Integer> initLottoNumbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
