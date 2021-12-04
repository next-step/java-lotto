package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.LottoTicket;
import step2.dto.WinningNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class LottoTicketTest {
    private Set<WinningNumber> numbers = new HashSet<>();

    @BeforeEach
    public void setNumber() {
        numbers.add(new WinningNumber(1));
        numbers.add(new WinningNumber(2));
        numbers.add(new WinningNumber(3));
        numbers.add(new WinningNumber(4));
        numbers.add(new WinningNumber(5));
        numbers.add(new WinningNumber(6));
    }

    @Test
    @DisplayName("반환된 값은 수정이 불가능한 컬렉션이다.")
    public void unmodifiableSet() {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThatThrownBy(() -> {
            lottoTicket.lottoTicket().add(new WinningNumber(7));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource("createSet")
    @DisplayName("포함하는 값이라면 포함한 갯수를 반환한다")
    public void contains(Set<WinningNumber> sets, int expected) {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.containsWinningNumber(sets)).isEqualTo(expected);
    }

    private static Stream<Arguments> createSet() {
        return Stream.of(
                arguments(new HashSet<>(Arrays.asList(new WinningNumber(1),new WinningNumber(2))), 2),
                arguments(new HashSet<>(Arrays.asList(new WinningNumber(3),new WinningNumber(7))), 1),
                arguments(new HashSet<>(Arrays.asList(new WinningNumber(10),new WinningNumber(12), new WinningNumber(13))), 0)
        );
    }

}
