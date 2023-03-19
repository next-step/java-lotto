package lotto;

import configuration.LottoConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        IntStream.range(LottoConfiguration.LOTTO_RANGE_MIN, LottoConfiguration.LOTTO_RANGE_MAX)
                .forEach(i -> lottoNumbers.add(LottoNumber.of(i)));
    }

    public static Lotto auto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers
                .stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList())
                );
    }
    public static Lotto manualLotto(List<Integer> numbers) {
        List<LottoNumber> manualNumbers = new ArrayList<>();
        numbers.forEach( i -> {
            manualNumbers.add(LottoNumber.of(i));
        });
        return new Lotto(manualNumbers);
    }
    public static WinningLotto manualWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> manualNumbers = new ArrayList<>();
        numbers.forEach( i -> {
            manualNumbers.add(LottoNumber.of(i));
        });
        return new WinningLotto(manualNumbers, bonusNumber);
    }
}
