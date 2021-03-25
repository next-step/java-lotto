package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private final List<Integer> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public static Lotto of() {
        return new Lotto(extractionLottoNumber());
    }

    private static List<Integer> extractionLottoNumber() {
        List<Integer> referenceNumbers = createReferenceNumbers();

        Collections.shuffle(referenceNumbers);

        return referenceNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> createReferenceNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            randomNumbers.add(i);
        }
        return randomNumbers;
    }

    public int getMatchCount(WinningNumber winningNumber) {
        return (int) lotto.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lotto;
    }
}
