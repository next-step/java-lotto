package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    private int matchCount = 0;

    public LottoNumbers() {
        List<Integer> seedNumbers = new ArrayList<>();
        for (int i = 0; i < 45; ++i) {
            seedNumbers.add(i + 1);
        }
        Collections.shuffle(seedNumbers);
        this.lottoNumbers = seedNumbers.subList(0, 6);
        this.validateDigit();
        this.validateRangeOfNumbers();
    }

    public LottoNumbers(Integer... numbers) {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(Arrays.asList(numbers));
        this.validateDigit();
        this.validateRangeOfNumbers();
    }

    public LottoNumbers(String numbers) {
        lottoNumbers = new ArrayList<>();
        String[] strArr = numbers.split(", ");
        for (String s : strArr) {
            lottoNumbers.add(Integer.parseInt(s));
        }
        this.validateDigit();
        this.validateRangeOfNumbers();
    }

    public List<Integer> numbers() {
        return this.lottoNumbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        for (int number : winningNumbers.numbers()) {
            matchCount = getMatchCount(number);
        }
        return matchCount;
    }

    private int getMatchCount(int number) {
        if (this.lottoNumbers.contains(number)) {
            ++matchCount;
        }
        return matchCount;
    }

    private void validateDigit() {
        Set<Integer> numbers = new HashSet<>(this.lottoNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 숫자 6개로 구성되어야 합니다.");
        }
    }

    private void validateRangeOfNumbers() {
        for (Integer number : this.lottoNumbers) {
            validateRange(number);
        }
    }

    private static void validateRange(Integer number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("로또는 1~45의 숫자만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }


}
