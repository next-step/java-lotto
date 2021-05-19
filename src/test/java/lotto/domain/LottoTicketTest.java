package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("provideListForNotValidLength")
    @DisplayName("6자리가 아닐 경우 예외가 발생한다")
    void lottoNumbersLengthExceptionTest(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> LottoTicket.of(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideListForNotValidLength() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

}