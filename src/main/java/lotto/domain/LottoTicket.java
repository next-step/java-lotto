package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                                         .boxed()
                                         .collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
