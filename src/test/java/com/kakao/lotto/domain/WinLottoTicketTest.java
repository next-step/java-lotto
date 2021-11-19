package com.kakao.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTicketTest {

    @Test
    @DisplayName("숫자 6개로 정답 로또 티켓을 발급할 수 있다.")
    void createWinLottoTicket() {
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(3, 4, 6, 5, 1, 2));
        assertThat(winLottoTicket.getLottoNumbers()).contains(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    @Test
    @DisplayName("정답 로또 티켓을 발급할 때 숫자가 6개가 아니면 에러")
    void ofFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("정답 티켓을 발급 할 때 6개 숫자를 입력하지만 중복되는 숫자가 있는 경우 에러")
    void ofFailDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

    @ParameterizedTest
    @DisplayName("정답 티켓과 일반 티켓을 비교하여 일치하는 숫자 수를 리턴한다.")
    @MethodSource("lottoMatchWinNumber")
    void matchWinNumber(int matchNumber, LottoTicket lottoTicket) {
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winLottoTicket.matchWinNumber(lottoTicket)).isEqualTo(matchNumber);
    }

    private static Stream<Arguments> lottoMatchWinNumber() {
        return Stream.of(
                Arguments.arguments(6, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.arguments(5, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45))),
                Arguments.arguments(4, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 44, 45))),
                Arguments.arguments(3, LottoTicket.of(Arrays.asList(1, 2, 3, 43, 44, 45))),
                Arguments.arguments(2, LottoTicket.of(Arrays.asList(1, 2, 42, 43, 44, 45))),
                Arguments.arguments(1, LottoTicket.of(Arrays.asList(1, 41, 42, 43, 44, 45))),
                Arguments.arguments(0, LottoTicket.of(Arrays.asList(40, 41, 42, 43, 44, 45)))
        );
    }
}
