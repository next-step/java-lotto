package lottogame.domain.response;

import java.util.Objects;
import java.util.Set;

public class LottoTicketResponse {

    private final Set<Integer> numbers;

    public LottoTicketResponse(Set<Integer> numbers) {
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
        if (!(o instanceof LottoTicketResponse)) {
            return false;
        }
        LottoTicketResponse that = (LottoTicketResponse) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "LottoTicketResponse{" +
            "numbers=" + numbers +
            '}';
    }
}
