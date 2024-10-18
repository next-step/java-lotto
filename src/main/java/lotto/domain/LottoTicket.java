package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public static LottoTicket createByString(String lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers.split(", "))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList())
        );
    }

    public static LottoTicket createRandom() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                                         .boxed()
                                         .collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(selectedNumbers);
        return new LottoTicket(selectedNumbers);
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 정확히 6개여야 합니다.");
        }

        if (lottoNumbers.stream()
                        .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int matchCount(LottoTicket winningNumbers) {
        return (int) lottoNumbers.stream()
                                 .filter(winningNumbers::contains)
                                 .count();
    }

    private boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
