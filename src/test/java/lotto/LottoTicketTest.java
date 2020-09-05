package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("일치하는 숫자 개수 확인")
    void drawing(LottoTicket lottoTicket, int count) {
        LottoNumbers winningNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.drawing(winningNumbers)).isEqualTo(count);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(new LottoTicket(LottoNumbers.of(7, 8, 9, 10, 11, 12)), 0),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 8, 9, 10, 11, 12)), 1),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 2, 9, 10, 11, 12)), 2),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 2, 3, 7, 8, 9)), 3),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 8, 9)), 4),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 5, 9)), 5),
                Arguments.of(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }
}
