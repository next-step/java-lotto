package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseInfoTest {

    @DisplayName("초기화테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:0", "2000:0", "1500000:0"}, delimiter = ':')
    public void initTest(String inputString, String selfChooseCount) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputString, selfChooseCount);
    }

    @DisplayName("초기화오류테스트_음수입력")
    @ParameterizedTest
    @CsvSource(value = {"-1:0", "-2000:0", "-1500000:0"}, delimiter = ':')
    public void initTest_음수입력(String inputString, String selfChooseCount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new PurchaseInfo(inputString, selfChooseCount));
    }

    @DisplayName("입력금액에 맞는 로또구매 매수")
    @ParameterizedTest
    @CsvSource(value = {"1000:0:1", "2000:0:2", "1500000:0:1500"}, delimiter = ':')
    public void getBoughtLottoCount(String inputString, String selfChooseCount, int boughtLotto) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputString, selfChooseCount);
        assertThat(purchaseInfo.getBoughtLottoCount()).isEqualTo(boughtLotto);
    }

}

