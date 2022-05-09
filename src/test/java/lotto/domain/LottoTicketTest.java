package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.LottoNumbers.generateLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTicketTest {
    @Test
    void LottoTicket는_lottoNumbers_없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoTicket(null, LottoTicketType.AUTO);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoTicket는_lottoTicketType_없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoTicket(generateLottoNumbers(1, 6), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1:5", "1:7"}, delimiter = ':')
    void LottoTicket는_올바르지_않은_개수로_생성시_예외를_발생시킨다(int from, int to) {
        assertThatThrownBy(() -> {
            new LottoTicket(generateLottoNumbers(from, to), LottoTicketType.AUTO);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check는_lottoPrize를_반환한다() {
        assertThat(new LottoTicket(generateLottoNumbers(1, 6), LottoTicketType.AUTO)
                .check(generateLottoNumbers(1, 6), new LottoNumber(7)))
                .isEqualTo(LottoPrize.FIRST);
    }

    @Test
    void isSameTicketType은_type이_같으면_true를_반환한다() {
        assertAll(
                () -> assertTrue(new LottoTicket(generateLottoNumbers(1, 6), LottoTicketType.AUTO)
                        .isSameTicketType(LottoTicketType.AUTO)),
                () -> assertFalse(new LottoTicket(generateLottoNumbers(1, 6), LottoTicketType.AUTO)
                        .isSameTicketType(LottoTicketType.MANUAL))
        );
    }
}
