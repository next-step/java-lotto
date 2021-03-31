package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final String WINNING_NUMBER_STRING_DELIMITER = ", ";
    private static final int START = 0;
    private static final int END = 6;
    private static final List<LottoNumber> AUTO_LOTTO = IntStream.rangeClosed(1, 45).mapToObj(LottoNumber::new).collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }

    private LottoNumbers getTreeSetLottoNumbers(Set<LottoNumber> lottoNumbers) {
        return LottoNumbers.of(lottoNumbers);
    }

    public LottoNumbers generateShuffledLotto() {
        Collections.shuffle(AUTO_LOTTO);
        return getTreeSetLottoNumbers(
                AUTO_LOTTO.subList(START, END)
                        .stream()
                        .collect(Collectors.toSet())
        );
    }

    public LottoNumbers generateAppointedLotto(final String appointedNumbers) {
        List<String> lottoNumberStringList =
                new ArrayList(Arrays.asList(appointedNumbers.split(WINNING_NUMBER_STRING_DELIMITER)));
        return getTreeSetLottoNumbers(
                lottoNumberStringList.stream()
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
        );
    }

    private static class LazyHolder {
        private static final LottoGenerator instance = new LottoGenerator();
    }
}
