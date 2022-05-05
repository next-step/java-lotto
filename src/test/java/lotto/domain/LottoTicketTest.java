package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.LottoNumbers.generateLottoNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    void LottoTicket는_lottoNumbers_없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoTicket(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1:5", "1:7"}, delimiter = ':')
    void LottoTicket는_올바르지_않은_개수로_생성시_예외를_발생시킨다(int from, int to) {
        assertThatThrownBy(() -> {
            new LottoTicket(generateLottoNumbers(from, to));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
