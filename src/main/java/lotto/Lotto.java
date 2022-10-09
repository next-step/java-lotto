package lotto;

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
        this.lottoNumbers = generateLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private List<Integer> generateLottoNumbers() {
        Collections.shuffle(lottoNumberCandidates);

        List<Integer> lottoNumbers = lottoNumberCandidates.subList(0, LOTTO_NUM_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
