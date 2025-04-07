package domain;

import data.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_BOUND = 45;
    private static final int REQUIRED_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumbers;
    private static final List<Integer> numbers = IntStream.rangeClosed(1, LOTTO_NUMBER_BOUND).boxed().collect(Collectors.toList());

    public LottoNumbers() {
        this.lottoNumbers = auto();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(Messages.NUMBER_OF_NUMBERS_ERROR);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String lottoNumbers) {
        this.lottoNumbers = manaul(lottoNumbers);
    }

    private List<Integer> manaul(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> auto() {

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0, REQUIRED_NUMBER_COUNT));

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public int getHitCount(List<Integer> winNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    public int getHitCount(LottoNumbers winNumbers) {
        return this.getHitCount(winNumbers.getLottoNumbers());
    }

    public boolean hasBonusNumber(int bonus) {
        return this.lottoNumbers.contains(bonus);
    }
}
