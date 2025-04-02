package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {
    private static final int SIZE = 6;
    private static final List<LottoNumber> BASE_NUMBERS = generateBaseNumbers();

    private static List<LottoNumber> generateBaseNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoTicket generateLottoTicket() {
        List<LottoNumber> numbers = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(numbers);
        List<LottoNumber> lottoNumbers = numbers.subList(0, SIZE).stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toUnmodifiableList());
        return new LottoTicket(lottoNumbers);
    }
}
