package lotto.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
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
}
