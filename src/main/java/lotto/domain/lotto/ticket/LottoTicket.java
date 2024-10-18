package lotto.domain.lotto.ticket;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_LENGTH_ERROR = "로또 입력 숫자가 6개가 아닙니다.";
    private final Set<LottoNumber> numbers;

    public LottoTicket(Integer... numbers) {
        this(Arrays.stream(numbers).map(LottoNumber::of).collect(Collectors.toList()));
    }

    public LottoTicket(String numbers) {
        this(Arrays.stream(parse(numbers))
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = new HashSet<>(numbers);

        if(this.numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR);
        }
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int hitNumber(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(numbers::contains).count();
    }

    public static String[] parse(String input) {
        String[] lottoNumbers = input.split(",");
        if (!validate(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR);
        }
        return lottoNumbers;
    }

    public static boolean validate(String[] lottoNum) {
        return lottoNum.length == 6;
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(this.numbers);
    }

    public List<String> displayNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }
}
