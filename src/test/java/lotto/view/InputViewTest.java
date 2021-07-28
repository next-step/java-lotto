package lotto.view;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @ValueSource(ints = {
            0,
            1000,
            10000
    })
    @ParameterizedTest
    public void inputViewTest_구매할금액(int intMoney) {
        assertThat(new FakeInputView(intMoney, "").inputMoney())
                .isEqualTo(intMoney);
    }

    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "11,22,33,44,45"
    })
    @ParameterizedTest
    public void inputViewTest_당첨로또번호(String strPrizeNumbers) {
        assertThat(new FakeInputView(0, strPrizeNumbers).inputPrizeNumbers())
                .isEqualTo(strPrizeNumbers);
    }
}