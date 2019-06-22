package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;

    private final List<Integer> lottoNumbers;

    public Lotto() {

        this.lottoNumbers = generateLottoNumbers();
        this.lottoNumbers.sort(Integer::compareTo);
    }

    public Lotto(List<Integer> lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
        this.lottoNumbers.sort(Integer::compareTo);
    }

    private List<Integer> generateLottoNumbers() {

        List<Integer> lottoNumberPool = IntStream.range(LOTTO_START, LOTTO_END).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberPool);
        return choiceLottoNumbers(lottoNumberPool);
    }

    private List<Integer> choiceLottoNumbers(List<Integer> lottoNumberPool) {

        return lottoNumberPool.subList(0, 6);
    }

    public boolean isLottoNumberMatchesCorrectCount(int correctCount, WonNumbers wonNumbers) {

        return getWonNumbersContainsCount(wonNumbers) == correctCount;
    }

    private long getWonNumbersContainsCount(WonNumbers wonNumbers) {

        return wonNumbers.getWonNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
