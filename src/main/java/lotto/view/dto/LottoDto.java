package lotto.view.dto;

import java.util.List;
import java.util.Objects;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
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
