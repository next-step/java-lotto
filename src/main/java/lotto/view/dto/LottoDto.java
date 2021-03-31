package lotto.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoDto {
    private final List<Integer> numbers;
    private final Integer bonusBall;

    public LottoDto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
        this.bonusBall = -1;
    }

    public LottoDto(List<Integer> numbers, Integer bonusBall) {
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public Integer getBonusBall() {
        return bonusBall;
    }

    public List<Integer> getNumbers() {
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
        LottoDto lottoDto = (LottoDto) o;
        return Objects.equals(numbers, lottoDto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
