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

class WinLottoTicketTest {

    @Test
    @DisplayName("숫자 6개와 보너스 번호 하나로 정답 로또 티켓을 발급할 수 있다.")
    void createWinLottoTicket() {
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(3, 4, 6, 5, 1, 2), 7);
        assertThat(winLottoTicket).isNotNull();
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호는 같을 수 없다.")
    void lottoBonusFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    @DisplayName("정답 로또 티켓을 발급할 때 숫자가 6개가 아니면 에러")
    void ofFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5), 8));
    }

    @Test
    @DisplayName("정답 티켓을 발급 할 때 6개 숫자를 입력하지만 중복되는 숫자가 있는 경우 에러")
    void ofFailDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 5), 7));
    }

    @ParameterizedTest
    @DisplayName("정답 티켓과 일반 티켓을 비교하여 일치하는 랭크를 리턴한다.")
    @MethodSource("lottoMatchWinNumber")
    void matchWinNumber(LottoRank lottoRank, LottoTicket lottoTicket) {
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winLottoTicket.matchLottoRank(lottoTicket)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> lottoMatchWinNumber() {
        return Stream.of(
                Arguments.arguments(LottoRank.FIRST, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.arguments(LottoRank.SECOND, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7))),
                Arguments.arguments(LottoRank.THIRD, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45))),
                Arguments.arguments(LottoRank.FOURTH, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 44, 45))),
                Arguments.arguments(LottoRank.FIFTH, LottoTicket.of(Arrays.asList(1, 2, 3, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(1, 2, 42, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(1, 41, 42, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(40, 41, 42, 43, 44, 45)))
        );
    }
}
