package lotto.model;

import lotto.exception.InvalidLottoTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    @DisplayName("로또 티켓을 생성한다")
    void createLottoTicket(Set<LottoNumber> lottoNumbers) {
        assertThat(new LottoTicket(lottoNumbers)).isInstanceOfAny(LottoTicket.class);
    }

    public static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6))),
                Arguments.of(
                        Set.of(
                                new LottoNumber(40),
                                new LottoNumber(41),
                                new LottoNumber(42),
                                new LottoNumber(43),
                                new LottoNumber(44),
                                new LottoNumber(45))),
                Arguments.of(
                        Set.of(
                                new LottoNumber(20),
                                new LottoNumber(21),
                                new LottoNumber(22),
                                new LottoNumber(23),
                                new LottoNumber(24),
                                new LottoNumber(25)))
        );
    }

    @Test
    @DisplayName("로또 티켓 생성 검증에 실패한다")
    void failLottoTicket() {
        assertThatThrownBy(() -> new LottoTicket(Set.of(new LottoNumber(2))))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

}