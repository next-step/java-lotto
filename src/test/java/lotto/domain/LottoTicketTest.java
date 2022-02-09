package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    private static final int LOTTO_PRICE = 1_000;

    @DisplayName(value = "정수 자료형인 Price로 LottoTicket 객체를 생성할때, LottoTicket의 개수는 가격을 LottoPrice 로 나눈것과 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 3_000, 10_000})
    void GivenPriceWithIntType_WhenGenerateLottoTicket_ThenLottoTicketSizeEqualsPriceDivideLottoPrice(
        final int price) {
        final int lottoTicketSize = LottoTicket.from(price).getLottoTicket().size();
        final int lottoCount = price / LOTTO_PRICE;

        assertThat(lottoTicketSize)
            .isEqualTo(lottoCount);
    }
}
