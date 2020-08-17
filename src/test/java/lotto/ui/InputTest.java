package lotto.ui;

import common.StringResources;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @Test
    public void inputNotPositiveNumber() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(0, null))
                        .inputMoney()
        ).withMessage(StringResources.ERR_MUST_BUY);

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(-1000, null))
                        .inputMoney()
        ).withMessage(StringResources.ERR_MUST_BUY);
    }

    @Test
    public void inputWrongUnitNumber() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(13500, null))
                        .inputMoney()
        ).withMessage(StringResources.ERR_WRONG_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1000, 2000, 3000, 4000, 5000 })
    public void inputMoneySuccess(int money) {
        assertThat(new LottoInput(when(money, null)).inputMoney()).isNotNull();
    }

    @Test
    public void inputLottoResultFail() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(0, null)).inputLottoResult()
        ).withMessage(StringResources.ERR_WRONG_RESULT_INPUT);

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(0, "")).inputLottoResult()
        ).withMessage(StringResources.ERR_WRONG_RESULT_INPUT);

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(0, "1,2,3,4,5,6")).inputLottoResult()
        ).withMessage(StringResources.ERR_WRONG_RESULT_INPUT);
    }

    @Test
    public void inputLottoResultSuccess() {
        Input input = when(7, "1, 2, 3, 4, 5, 6");
        assertThat(new LottoInput(input).inputLottoResult()).isNotNull();
    }

    private Input when(final int money, final String line) {
        return new Input() {
            @Override
            public int nextInt() {
                return money;
            }

            @Override
            public String nextLine() {
                return line;
            }
        };
    }
}
