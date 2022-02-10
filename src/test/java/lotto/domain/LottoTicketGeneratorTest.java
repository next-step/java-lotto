package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.strategy.RandomGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketGeneratorTest {

    private static final int LOTTO_PRICE = 1_000;

    static Stream<Arguments> generateValidPriceInputCountOutput() {
        List<Integer> countList = Arrays.asList(1, 2, 3, 10, 20, 30);

        return countList.stream().map(count -> Arguments.of(count, count * LOTTO_PRICE));
    }

    @DisplayName(value = "Price 자료형인 LottoPrice 로 LottoTicketGenerator 객체를 생성할때, LottoTicket.size()는 LottoCount와 동일하다.")
    @ParameterizedTest
    @MethodSource("generateValidPriceInputCountOutput")
    void GivenLottoPriceWithPriceType_WhenGenerateLottoTicketGenerator_ThenLottoTicketSizeEqualsLottoCount(
        final int count, final int price) {
        final Price lottoPrice = Price.from(price);
        final int lottoTicketSize = LottoTicketGenerator.from(lottoPrice)
            .getLottoTicket()
            .getLottoList()
            .size();

        assertThat(lottoTicketSize)
            .isEqualTo(count);
    }
}
