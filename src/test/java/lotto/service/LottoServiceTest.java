package lotto.service;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @DisplayName("구매할 금액과 수동으로 사려는 로또의 수량 비교")
    @ParameterizedTest
    @CsvSource(value = {"3000:2", "1111:1", "2999:1"}, delimiter = ':')
    public void validateAvailableQuantity_success(int inputMoney, String count) throws Exception {
        //given
        LottoService lottoService = new LottoService();

        //when
        int result = lottoService.validateAvailableQuantity(count, new Money(inputMoney));

        //then
        assertThat(result).isEqualTo(Integer.parseInt(count));
    }
}
