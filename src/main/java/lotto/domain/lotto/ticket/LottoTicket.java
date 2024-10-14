package lotto.domain.lotto.ticket;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private final static String LOTTO_LENGTH_ERROR = "로또 입력 숫자가 6개가 아닙니다.";
    private final List<LottoNumber> numbers;

    public LottoTicket(Integer... numbers) {
        this(Arrays.stream(numbers).map(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoTicket(String numbers) {
        this.numbers = Arrays.stream(parse(numbers))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int hitNumber(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(numbers::contains).count();
    }

    public String[] parse(String input) {
        String[] lottoNumbers = input.split(",");
        if (!validate(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR);
        }
        return lottoNumbers;
    }

    public boolean validate(String[] lottoNum) {
        return lottoNum.length == 6;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public List<LottoNumber> sortAsc() {
        numbers.sort(new Comparator<LottoNumber>() {
            @Override
            public int compare(LottoNumber o1, LottoNumber o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });

        return numbers;
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
        return numbers + "\n";
    }
}
