package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_COUNT = 6;

    private static final List<Integer> lottoNumberCandidates = IntStream
            .range(1, LOTTO_NUM_MAX + 1)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public Lotto() {
        this(generateLottoNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private static List<Integer> generateLottoNumbers() {
        Collections.shuffle(lottoNumberCandidates);
        List<Integer> lottoNumbers = lottoNumberCandidates.subList(0, LOTTO_NUM_COUNT);
        Collections.sort(lottoNumbers);

        return new ArrayList<>(lottoNumbers);
    }

    public int countEqualNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .mapToInt(lottoNumber -> 1)
                .sum();
    }
}
