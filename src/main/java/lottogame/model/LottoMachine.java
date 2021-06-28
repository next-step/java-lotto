package lottogame.model;


import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoMachine {

    final static int NUMBER_COUNT_PER_GAME = 6;

    public Lotto generateAutoLotto() {
        Collections.shuffle(LottoNumbers.numbers);
        Set<LottoNumber> lottoNumbers = LottoNumbers.numbers.stream()
                .limit(NUMBER_COUNT_PER_GAME)
                .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    public Lotto generateManualLotto(String lottoNumbersStr) {

        Set<LottoNumber> lottoNumbers = new TreeSet<>(
                Arrays.asList(lottoNumbersStr).stream()
                        .map(number -> Integer.valueOf(number))
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet()));

        return new Lotto(lottoNumbers);
    }


}
