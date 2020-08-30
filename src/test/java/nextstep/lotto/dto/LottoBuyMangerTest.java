package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoBuyMangerTest {

    @ParameterizedTest
    @CsvSource(value = {"5600,3,2"}, delimiter = ',')
    @DisplayName("수동번호 생성에따른 자동번호 갯수확인")
    void LottoBuyManagerCreate_Test(int inputMoney, int manualAmount, int autoAmount) {
        LottoBuyManger lottoBuyManger = LottoBuyManger.create(inputMoney, manualAmount);
        assertThat(lottoBuyManger.getAutoAmount()).isEqualTo(autoAmount);
        assertThat(lottoBuyManger.getManualLottoAmount()).isEqualTo(manualAmount);
    }

    @ParameterizedTest
    @CsvSource(value = {"5600,6"}, delimiter = ',')
    @DisplayName("수동번호의 갯수는 전체 로또의 갯수를 초과할수 없음")
    public void manualAmountGreateThanTotalTest(int inputMoney, int manualAmount) throws Exception {
        assertThatThrownBy(() ->
                LottoBuyManger.create(inputMoney, manualAmount)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
