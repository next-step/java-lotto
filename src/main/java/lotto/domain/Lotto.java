package lotto.domain;

import lotto.domain.value.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final String FORM_ERROR_MSG = "로또는 6자리 형식입니다.!!!";
    private static Random random = new Random();

    private Set<LottoNumber> numbers;

    public Lotto() {

        this.numbers = createRandomNumbers();
    }

    private Lotto(Set<LottoNumber> numbers) {

        if(numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(FORM_ERROR_MSG);
        }

        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> number) {
        return new Lotto(number.stream()
                .collect(Collectors.toSet()));
    }

    public static Lotto winningFrom(List<Integer> number) {

        Set<LottoNumber> numbers = new TreeSet<>();
        Iterator<Integer> itr = number.iterator();
        while(itr.hasNext()) {
            numbers.add(new LottoNumber(itr.next()));
        }

        return new Lotto(numbers);
    }

    private Set<LottoNumber> createRandomNumbers() {

        Set<LottoNumber> autoNumbers = new TreeSet<>();

        while (autoNumbers.size() != LOTTO_SIZE) {
            int raffleNumber = random.nextInt(LOTTO_MAX_NUMBER -1) + 1;
            LottoNumber randomNumber = new LottoNumber(raffleNumber);
            autoNumbers.add(randomNumber);

        }

        return autoNumbers;
    }

    public int calculatePrizeMoney(Lotto winningNumbers) {
        return Rank.valueOf(countOfMatch(winningNumbers)).getPrizeMoney();
    }

    private int countOfMatch(Lotto winningNumbers) {

        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count() == count;
    }

    private boolean contains(LottoNumber lottoNumber) {

        Iterator<LottoNumber> itr = numbers.iterator();
        while(itr.hasNext()) {
            if(isValueEqual(itr.next(), lottoNumber)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValueEqual(LottoNumber winningNumber, LottoNumber lottoNumber) {
        if(lottoNumber.equals(winningNumber)) {
            return true;
        }

        return false;
    }


    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
