package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseInfoTest {

    @DisplayName("초기화테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "2000:1000", "1500000:1000"}, delimiter = ':')
    public void initTest(String inputString, int price) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputString, price);
    }

    @DisplayName("초기화오류테스트_음수입력")
    @ParameterizedTest
    @CsvSource(value = {"-1:1000", "-2000:1000", "-1500000:1000"}, delimiter = ':')
    public void initTest_음수입력(String inputString, int price) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new PurchaseInfo(inputString, price));
    }

    @DisplayName("입력금액에 맞는 로또구매 매수")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000:1", "2000:1000:2", "1500000:1000:1500"}, delimiter = ':')
    public void getBoughtLottoCount(String inputString, int price, int boughtLotto) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputString, price);
        assertThat(purchaseInfo.getBoughtLottoCount()).isEqualTo(boughtLotto);
    }

}

