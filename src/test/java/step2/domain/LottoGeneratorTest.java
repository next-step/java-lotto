package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Constants;
import step2.domain.enums.WinnerPriceType;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoGenerator 테스트")
class LottoGeneratorTest {
    private int lottoAmount = 3;

    private LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(lottoAmount, new TestLottoGeneratorStrategy(Constants.INIT_LOTTO_GENERATOR_STRATEGY_NUMBER));

    @DisplayName("로또생성기 동작 확인")
    @Test
    void lottoGenerateTest() {
        assertThat(lottoTicketGenerator.getLottoTicket()).isInstanceOf(LottoTicket.class);
        assertThat(lottoTicketGenerator.getLottoTicket().getLottos().size()).isEqualTo(lottoAmount);
    }
}
