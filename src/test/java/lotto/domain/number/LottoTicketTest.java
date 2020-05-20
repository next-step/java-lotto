package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTicketTest {

    @DisplayName("LottoTicket 생성")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void create(final List<Integer> numbers) {
        assertThatCode(() -> LottoTicket.of(numbers))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(1, 11, 24, 33, 44, 45))
        );
    }
}
