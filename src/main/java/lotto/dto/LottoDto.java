package lotto.dto;

import lotto.domain.Lotto;

import java.util.Set;

public class LottoDto {
    private final Set<Integer> numbers;

    public LottoDto(Lotto lotto) {
        this(lotto.toIntSet());
    }

    public LottoDto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> numbers() {
        return numbers;
    }
}
