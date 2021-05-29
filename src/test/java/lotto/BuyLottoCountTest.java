package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoCountTest {
    @DisplayName("유저가 산 로또 갯수 객체 생성 테스트")
    @ParameterizedTest
    @CsvSource({"5,10", "6,11"})
    void createAutoLottoCount(int manualLottoCountInput, int autoLottoCountInput) {
        BuyLottoCount buyLottoCount = new BuyLottoCount(manualLottoCountInput, autoLottoCountInput);
        assertThat(buyLottoCount).isEqualTo(new BuyLottoCount(manualLottoCountInput, autoLottoCountInput));
    }

    @DisplayName("수동 로또 번호 생성 카운트 유효성 체크")
    @ParameterizedTest
    @CsvSource({"10,9000", "2,1200"})
    void countBuyAutoLottoCount(int manualLottoCountInput, int payForLotto) {
        assertThatThrownBy(() -> new BuyLottoCount(manualLottoCountInput , new Pay(payForLotto)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
