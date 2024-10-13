package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int START = 0;
    private static final int END = 6;
    private static final int SIZE = 6;

    private final TreeSet<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        TreeSet<LottoNumber> temporary = new TreeSet<>();
        for (int i = 1; i <= 45; i++) {
            temporary.add(new LottoNumber(i));
        }
        this.lottoNumbers = temporary;
    }

    public LottoNumbers(Integer... numbers) {
        this(Arrays.stream(numbers).map(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        this(new TreeSet<>(numbers));
    }

    public LottoNumbers(TreeSet<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = numbers;
    }

    public Rank calculateRank(WinNumber winNumber, LottoNumber bonus) {
        int matchCount = 0;

        for (LottoNumber number : lottoNumbers) {
            matchCount = winNumber.contains(number) ? matchCount + 1 : matchCount;
        }

        if (Rank.match(matchCount) == Rank.FOUR) {
            return checkSecond(bonus);
        }

        return Rank.match(matchCount);
    }

    public LottoNumbers pickNumbers() {
        ArrayList<LottoNumber> temporary = new ArrayList<>(lottoNumbers);

        shuffle(temporary);
        List<LottoNumber> pickedNumbers = temporary.subList(START, END);
        sort(pickedNumbers);

        LottoNumbers lottoNumbers1 = new LottoNumbers(pickedNumbers);

        return lottoNumbers1;
    }

    public List<Integer> getValues() {
        return lottoNumbers.stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private Rank checkSecond(LottoNumber bonus) {
        if (lottoNumbers.contains(bonus)) {
            return Rank.SECOND;
        }
        return Rank.FOUR;
    }

    private void shuffle(List<LottoNumber> baseNumbers) {
        Collections.shuffle(baseNumbers);
    }

    private void sort(List<LottoNumber> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumbers))
            return false;
        LottoNumbers that = (LottoNumbers)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
