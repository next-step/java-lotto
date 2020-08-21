package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    private static Stream<Arguments> provideListForGetCountOfMatch() {
        return Stream.of(
                Arguments.of(Arrays.asList(5, 9, 11, 21, 29, 35), Arrays.asList(10, 11, 21, 35, 40, 45), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 40, 43, 45), Arrays.asList(10, 11, 12, 20, 30, 31), 0),
                Arguments.of(Arrays.asList(10, 17, 21, 28, 39, 45), Arrays.asList(10, 17, 21, 28, 39, 45), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideListForGetCountOfMatch")
    @DisplayName("다른 로또 티켓과 비교하여 일치하는 번호 개수 반환")
    void getCountOfMatch(List<Integer> numbers, List<Integer> otherNumbers, int expectedResult) {
        // given
        LottoTicket lottoTicket = LottoTicket.of(numbers);
        LottoTicket otherLottoTicket = LottoTicket.of(otherNumbers);

        // when
        int result = lottoTicket.getCountOfMatch(otherLottoTicket);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}