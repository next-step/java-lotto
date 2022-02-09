package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketGeneratorTest {

    @DisplayName(value = "정수 자료형인 LottoCount 로 LottoTicketGenerator 객체를 생성할때, LottoTicket.size()는 LottoCount와 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10, 20, 30})
    void GivenLottoCountWithIntType_WhenGenerateLottoTicketGenerator_ThenLottoTicketSizeEqualsLottoCount(final int lottoCount) {
        final int lottoTicketSize = LottoTicketGenerator.from(lottoCount).getLottoTicket().size();

        assertThat(lottoTicketSize)
            .isEqualTo(lottoCount);
    }
}