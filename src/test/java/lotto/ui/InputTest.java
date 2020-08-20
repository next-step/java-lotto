package lotto.ui;

import common.StringResources;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    public void inputNotPositiveNumber() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(0, null))
                        .inputPrincipal()
        ).withMessage(StringResources.ERR_MUST_BUY);

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(-1000, null))
                        .inputPrincipal()
        ).withMessage(StringResources.ERR_MUST_BUY);
    }

    @Test
    public void inputWrongUnitNumber() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoInput(when(13500, null))
                        .inputPrincipal()
        ).withMessage(StringResources.ERR_WRONG_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1000, 2000, 3000, 4000, 5000 })
    public void inputMoneySuccess(int money) {
        assertThat(new LottoInput(when(money, null)).inputPrincipal()).isNotNull();
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

    @Test
    public void inputManualLottoCountTest() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int inputMoney = 1000;
        Input input = when(inputMoney, null);

        LottoInput lottoInput = new LottoInput(input);
        int methodOutput = lottoInput.inputManualLottoCount();

        assertEquals(methodOutput, inputMoney);
        assertEquals(outContent.toString(), StringResources.MSG_MANUAL_LOTTO_COUNT + "\n");
    }

    @Test
    public void inputManualLottoListTest() {

        String numberStr = "1, 2, 3, 4, 5, 6";
        LottoInput lottoInput = new LottoInput(when(0, numberStr));

        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoInput.inputManualLottoList(5)
        ).withMessage(StringResources.ERR_WRONG_RANGE_NUMBER);
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
