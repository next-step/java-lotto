package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTicketTest {
    private Set<LottoNumber> numbers = new HashSet<>();

    @BeforeEach
    public void setNumber() {
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
        assertThatThrownBy(() -> {
            new LottoTicket(numbers).lottoTicket().add(new LottoNumber(7));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource("createSet")
    @DisplayName("지난 당첨번호를 인자로 받을 시 가지고 있는 번호와 일치하는 갯수를 반환한다")
    public void contains(Set<LottoNumber> input, int expected) {
        assertThat(new LottoTicket(numbers).containsWinningNumber(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> createSet() {
        return Stream.of(
                arguments(new HashSet<>(Arrays.asList(new LottoNumber(1),new LottoNumber(2))), 2),
                arguments(new HashSet<>(Arrays.asList(new LottoNumber(3),new LottoNumber(7))), 1),
                arguments(new HashSet<>(Arrays.asList(new LottoNumber(3),new LottoNumber(4), new LottoNumber(5))), 3)
        );
    }
}
