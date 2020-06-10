package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step4.domain.LottoShop;
import study.step4.dto.LottoInputDto;
import study.step4.dto.LottoOutputDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoShopTest {

    @ParameterizedTest
    @DisplayName("로또 구입금액이 1000원보다 적을 경우 예외발생 테스트")
    @ValueSource(ints = {100, 800, 990})
    public void buyLottoTicketsExceptionTest(long price){
        LottoInputDto lottoInputDto = new LottoInputDto(price, 0, null);
        assertThatThrownBy(() -> LottoShop.buyLottos(lottoInputDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력시 그에 맞는 로또 갯수 구매되는지 테스트")
    @CsvSource(value = {"10000:10", "14000:14", "20000:20", "31500:31"}, delimiter = ':')
    public void buyLottoTicketsTest(long price, int lottoCounting){
        LottoInputDto lottoInputDto = new LottoInputDto(price, 0, null);
        LottoOutputDto lottoOutputDto = LottoShop.buyLottos(lottoInputDto);
        assertThat(lottoOutputDto.getlottoTickets())
                .hasSize(lottoCounting);
    }

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력시 그에 맞는 로또 갯수 구매되는지 테스트 - 수동 추가")
    @CsvSource(value = {"10000:10", "14000:14", "20000:20", "31500:31"}, delimiter = ':')
    public void buyLottoManualTicketsTest(long price, int lottoCounting){
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add("1,2,3,4,5,6");
        inputNumbers.add("5,6,7,8,9,10");
        LottoInputDto lottoInputDto = new LottoInputDto(price, inputNumbers.size(), inputNumbers);

        LottoOutputDto lottoOutputDto = LottoShop.buyLottos(lottoInputDto);
        assertThat(lottoOutputDto.getlottoTickets())
                .hasSize(lottoCounting);
    }
}
