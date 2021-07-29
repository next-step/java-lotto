package lotto.domain;

import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMachineTest {

    @DisplayName("구입금액이 1000원 미만일때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    void validateAmount_구입가격이_1000원_미만(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoMachine(input, new AutoPurchaseStrategy());
        }).withMessageMatching("최소 1000원 이상 지불하셔야 합니다.");
    }

    @DisplayName("구입금액이 1000원 이상일때 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1000, 1500, 2000})
    void validateAmount_구입가격이_1000원_이상(int input) {
        assertThat(new LottoMachine(input, new AutoPurchaseStrategy())).isInstanceOf(LottoMachine.class);
    }

    @DisplayName("로또용지가 넣은 돈만큼 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1700:1", "5600:5", "20000:20"}, delimiter = ':')
    void validateAmount_로또용지(int amount, int lottoCount) {
        LottoMachine lottoMachine = new LottoMachine(amount, new AutoPurchaseStrategy());
        assertThat(lottoMachine.drawing().size()).isEqualTo(lottoCount);
    }

}
