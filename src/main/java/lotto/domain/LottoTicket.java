package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;
    private final List<Integer> numbers;

    private static final int NUMBERS_OF_BALLS = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public LottoTicket(List<Integer> lottoNumbers, List<Integer> numbers) {
        this.lottoNumbers = lottoNumbers;
        this.numbers = numbers;
    }

    public LottoTicket() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public List<Integer> generate() {
        for (int i = 0; i < NUMBERS_OF_BALLS; i++) {
            this.lottoNumbers.add(randomNumbers().get(i));
        }
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    protected List<Integer> randomNumbers() {
        for (int i = 0; i < MAX_NUMBER; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
