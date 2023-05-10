package lotto.domain.lottocreator;

import lotto.domain.LottoNo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_NUMBER = 6;

    private static List<LottoNo> lottoNos = IntStream.range(LottoNo.MIN_LOTTO_NUMBER, LottoNo.MAX_LOTTO_NUMBER)
            .boxed().map(number -> LottoNo.of(number)).collect(Collectors.toList());

    public static Lotto createAutoLotto() {
        Collections.shuffle(lottoNos);
        return new Lotto(lottoNos.stream().limit(LOTTO_NUMBER).collect(Collectors.toList()));
    }

    public static Lotto createManualLotto(String manualNumbers) {
        List<LottoNo> numbers = split(manualNumbers);
        return new Lotto(numbers);
    }

    public static Lotto createWinningLotto(String winningNumbers) {
        return createManualLotto(winningNumbers);
    }

    private static List<LottoNo> split(String numbers) {
        String[] number = numbers.split(", ");
        return Arrays.stream(number).map(num -> LottoNo.of(Integer.parseInt(num))).collect(Collectors.toList());
    }
}
