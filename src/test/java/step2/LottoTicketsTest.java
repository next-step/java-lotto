package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    private Set<LottoNumber> numbers = new HashSet<>();

    @BeforeEach
    public void setNumber() {
        numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));
    }

    @Test
    @DisplayName("반환된 값은 수정이 불가능한 컬렉션이다.")
    public void unmodifiableSet() {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThatThrownBy(() -> {
            new LottoTickets(Arrays.asList(lottoTicket)).lottoTickets().add(lottoTicket);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
