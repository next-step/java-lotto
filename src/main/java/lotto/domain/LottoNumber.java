package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = new ArrayList<>();

    private final int number;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            ALL_LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static List<LottoNumber> getRandomNumbers(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(lottoNumbers);

        lottoNumbers = lottoNumbers.subList(0, count);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public static LottoNumber of(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1~45 이외의 숫자가 포함되어 있습니다.");
        }

        return ALL_LOTTO_NUMBERS.stream().filter(n -> n.number == number).findAny().get();
    }

    public static List<LottoNumber> of(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }
}
