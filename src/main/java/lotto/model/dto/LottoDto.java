package lotto.model.dto;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class LottoDto {
    private final List<Number> numbers;

    private LottoDto(List<Number> numbers) {
        this.numbers = unmodifiableList(numbers);
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.numbers());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
