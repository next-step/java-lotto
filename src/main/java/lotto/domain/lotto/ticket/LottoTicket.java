package lotto.domain.lotto.ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> numbers;

    public LottoTicket(Integer... numbers) {
        this(Arrays.stream(numbers).map(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoTicket(String numbers) {
        String[] lottoNum = numbers.split(",");
        this.numbers = Arrays.stream(lottoNum).map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int hitNumber(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(numbers::contains).count();
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
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
        return numbers+"\n";
    }
}
