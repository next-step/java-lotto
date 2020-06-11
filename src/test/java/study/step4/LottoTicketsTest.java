package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step4.domain.LottoShop;
import study.step4.dto.LottoInputDto;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("로또 발행횟수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:0:14", "20000:0:20", "5000:0:5"}, delimiter = ':')
    public void publishLottoTicketsTest(int price, long manualAmount, long totalCount){
        LottoInputDto lottoInputDto = new LottoInputDto(price,  manualAmount, null);
        assertThat(LottoShop.buyLottos(lottoInputDto).getLottoTickets().size())
                                                    .isEqualTo(totalCount);
    }
}
