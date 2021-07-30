package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @DisplayName("inputMoney Test")
    @ValueSource(ints = {
            0,
            1000,
            10000
    })
    @ParameterizedTest
    public void inputMoneyTest(int intMoney) {
        assertThat(new FakeInputView(intMoney, "").inputMoney())
                .isEqualTo(intMoney);
    }

    @DisplayName("inputPrizeNumbers Test")
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "11,22,33,44,45"
    })
    @ParameterizedTest
    public void inputPrizeNumbersTest(String strPrizeNumbers) {
        assertThat(new FakeInputView(0, strPrizeNumbers).inputPrizeNumbers())
                .isEqualTo(strPrizeNumbers);
    }
}