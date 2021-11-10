package lotto.service.domain;

import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumberTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호에 포함된 로또번호 갯수 체크 검증")
    void getMatchingCount(WinningLottoNumber winningLottoNumber, LottoTicket muLottoTicket, Integer expected) {
        // when
        Integer matchingCount = winningLottoNumber.getMatchingCount(muLottoTicket);

        // then
        assertThat(matchingCount).isEqualTo(expected);
    }


    private static Stream<Arguments> getMatchingCount() {
        // given
        return Stream.of(
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        6),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(2), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        5),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(3),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        4),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        3),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(5), LottoNumber.from(6))),
                        2),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(15),
                                                       LottoNumber.from(6))),
                        1),
                Arguments.of(
                        WinningLottoNumber.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))),
                        LottoTicket.from(Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                                                       LottoNumber.from(14), LottoNumber.from(15),
                                                       LottoNumber.from(16))),
                        0)
        );
    }

}
