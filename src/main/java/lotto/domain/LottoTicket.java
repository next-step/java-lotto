package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        lottoNumbers = createLottoNumbers();
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = createNumber();

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                        .limit(6)
                        .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    private List<Integer> createNumber() {
        return Stream.iterate(MIN_NUMBER, i -> i + 1)
                .limit(MAX_NUMBER)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
