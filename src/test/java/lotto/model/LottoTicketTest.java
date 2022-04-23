package lotto.model;

import lotto.exception.InvalidLottoTicketException;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
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
                                LottoNumber.create(1),
                                LottoNumber.create(2),
                                LottoNumber.create(3),
                                LottoNumber.create(4),
                                LottoNumber.create(5),
                                LottoNumber.create(6))),
                Arguments.of(
                        Set.of(
                                LottoNumber.create(40),
                                LottoNumber.create(41),
                                LottoNumber.create(42),
                                LottoNumber.create(43),
                                LottoNumber.create(44),
                                LottoNumber.create(45))),
                Arguments.of(
                        Set.of(
                                LottoNumber.create(20),
                                LottoNumber.create(21),
                                LottoNumber.create(22),
                                LottoNumber.create(23),
                                LottoNumber.create(24),
                                LottoNumber.create(25)))
        );
    }

    @Test
    @DisplayName("로또 티켓 생성 검증에 실패한다")
    void failLottoTicket() {
        assertThatThrownBy(() -> new LottoTicket(Set.of(LottoNumber.create(2))))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

}