package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_NUMBER = 6;

    private static List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
            .boxed().map(number -> LottoNumber.of(number)).collect(Collectors.toList());

    public static Lotto create() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.stream().limit(LOTTO_NUMBER).collect(Collectors.toList()));
    }

    public static Lotto createManualLotto(String winningLottos) {
        List<LottoNumber> numbers = split(winningLottos);
        return new Lotto(numbers);
    }

    private static List<LottoNumber> split(String numbers) {
        String[] number = numbers.split(", ");
        return Arrays.stream(number).map(num -> LottoNumber.of(Integer.parseInt(num))).collect(Collectors.toList());
    }
}
