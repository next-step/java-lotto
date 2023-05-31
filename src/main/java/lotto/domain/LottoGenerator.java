package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int START_LOTTO_NUMBER = 1;
    public static final int END_LOTTO_NUMBER = 45;
    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        lottoNumbers = IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    public List<Integer> lotto() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6)
                .stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    public List<Lotto> manual(List<String> manualLottos) {
        return manualLottos.stream()
                .map(lotto -> Arrays.stream(lotto.split(",\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .map(numbers -> new Lotto(numbers))
                .collect(Collectors.toList());
    }

    public List<Lotto> auto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(lotto()))
                .collect(Collectors.toList());
    }
}
