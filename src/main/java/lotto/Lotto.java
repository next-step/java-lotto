package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> LOTTO_ALL_NUMBERS = createAllNumberOfLotto();

    private final List<Integer> lottoNumbers;

    Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int computeCountOfMatch(List<Integer> findNumbers) {
        return (int) findNumbers.stream()
                                .filter(this.lottoNumbers::contains)
                                .count();
    }

    private static List<Integer> createAllNumberOfLotto() {
        return IntStream.range(1, 46)
                        .boxed()
                        .collect(Collectors.toList());
    }

    private List<Integer> createLottoNumbers() {
        Collections.shuffle(LOTTO_ALL_NUMBERS);
        return new ArrayList<>(LOTTO_ALL_NUMBERS.subList(0, 6));
    }
}
