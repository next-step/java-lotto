package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private int matchCount = 0;

    public LottoNumbers() {
        List<Integer> seedNumbers = new ArrayList<>();
        for (int i = 0; i < 45; ++i) {
            seedNumbers.add(i + 1);
        }
        Collections.shuffle(seedNumbers);
        seedNumbers.subList(0, 6).forEach(n -> {
            this.lottoNumbers.add(new LottoNumber(n));

        });
        this.validateDigit();
    }

    public LottoNumbers(Integer... numbers) {
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        this.validateDigit();
    }

    public LottoNumbers(String numbers) {
        String[] strArr = numbers.split(", ");
        for (String s : strArr) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }
        this.validateDigit();
    }

    public List<LottoNumber> numbers() {
        return this.lottoNumbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        for (LottoNumber number : winningNumbers.numbers()) {
            matchCount = getMatchCount(number);
        }
        return matchCount;
    }

    private int getMatchCount(LottoNumber number) {
        if (this.lottoNumbers.contains(number)) {
            ++matchCount;
        }
        return matchCount;
    }

    private void validateDigit() {
        Set<LottoNumber> numbers = new HashSet<>(this.lottoNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 숫자 6개로 구성되어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
