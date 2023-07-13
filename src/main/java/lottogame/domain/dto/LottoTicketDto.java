package lottogame.domain.dto;

import java.util.Objects;
import java.util.Set;

public class LottoTicketDto {

    private final Set<Integer> numbers;

    public LottoTicketDto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicketDto)) {
            return false;
        }
        LottoTicketDto that = (LottoTicketDto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "LottoTicketDto{" +
            "numbers=" + numbers +
            '}';
    }
}
