package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public static List<Integer> extractionLottoNumber() {
        List<Integer> referenceNumbers = createReferenceNumbers();

        Collections.shuffle(referenceNumbers);

        return referenceNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> createReferenceNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            randomNumbers.add(i);
        }
        return randomNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lotto;
    }
}
