package lotto.service.domain;

import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호에 포함된 로또번호 갯수 체크 검증")
    void getMatchingCount(LottoTicket myLottoTicket, LottoTicket winnerLottoTicket, Integer expected) {
        // when
        Integer matchingCount = myLottoTicket.getMatchingCount(winnerLottoTicket);

        // then
        assertThat(matchingCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또번호가 없는 경우 예외 발생")
    void exception() {
        assertThatNullPointerException().isThrownBy(() -> LottoTicket.from(null));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또번호 갯수가 1보다 작거나 6보다 큰 경우 예외 발생 검증")
    void exception2(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.from(numbers));
    }

    private static Stream<Arguments> getMatchingCount() {
        // given
        return Stream.of(
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        6),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        5),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        4),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        3),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(5), LottoNumber.from(6))),
                        2),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(15),
                                                       LottoNumber.from(6))),
                        1),
                Arguments.of(
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(15),
                                                       LottoNumber.from(16))),
                        0)
        );
    }

    private static Stream<Arguments> exception2() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(
                        Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                      LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6),
                                      LottoNumber.from(7))));
    }
}
