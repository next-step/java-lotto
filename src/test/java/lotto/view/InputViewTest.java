package lotto.view;

import lotto.common.MessageCode;
import lotto.domain.LottoNo;
import lotto.domain.LottoNumbers;
import lotto.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    public void convertingStringToLottoNumbersArray_String배열에서_LottoNumbers배열로_변환_검증() {
        InputView inputView = new InputView();
        String [] lottoNumbersArray = new String[2];
        lottoNumbersArray[0] = "1,2,3,4,5,6";
        lottoNumbersArray[1] = "7,8,9,10,11,12";
        LottoNumbers[] lottoNumbers = inputView.convertingStringToLottoNumbersArray(lottoNumbersArray);
        assertThat(lottoNumbers[0].contains(new LottoNo(1))).isTrue();
        assertThat(lottoNumbers[0].contains(new LottoNo(2))).isTrue();
        assertThat(lottoNumbers[0].contains(new LottoNo(3))).isTrue();
        assertThat(lottoNumbers[0].contains(new LottoNo(4))).isTrue();
    }

    @Test
    public void parsingInputLottoNumbers_String파싱해서_LottoNumber로_변환_검증() {
        InputView inputView = new InputView();
        String inputLottoNumber = "1,5,8,21,23,31";
        LottoNumbers lottoNumbers = inputView.parsingInputLottoNumbers(inputLottoNumber);
        assertThat(lottoNumbers.contains(new LottoNo(1))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(5))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(23))).isTrue();
    }

    @Test
    public void inputMoney_1000미만금액_검증() {
        InputView inputView = new InputView();
        assertThatThrownBy( ()-> inputView.inputMoneyValidate(800))
                .isInstanceOf(MoneyNotEnoughException.class)
                .hasMessage((MessageCode.INVALID_INPUT_MONEY.message()));
    }

    @Test
    public void inputManualLottoBuyCountValidate_구매가능한수동로또개수_검증() {
        InputView inputView = new InputView();
        assertThatThrownBy( ()-> inputView.inputManualLottoBuyCountValidate(3, 2000))
                .isInstanceOf(ManualLottoCountException.class)
                .hasMessage((MessageCode.INVALID_INPUT_MANUAL_LOTTO_NUMBER.message()));
    }

    @Test
    public void validateInputFormat_검증() {
        InputView inputView = new InputView();
        assertThatThrownBy( ()-> inputView.validateInputFormat("1,2,,,"))
                .isInstanceOf(InputFormatException.class)
                .hasMessage((MessageCode.INVALID_INPUT_FORMAT_NUMBERS.message()));

        assertThatThrownBy( ()-> inputView.validateInputFormat("1,2,fd,s"))
                .isInstanceOf(InputFormatException.class)
                .hasMessage((MessageCode.INVALID_INPUT_FORMAT_NUMBERS.message()));

        assertThatThrownBy( ()-> inputView.validateInputFormat("12,122,111,33,5,4,"))
                .isInstanceOf(InputFormatException.class)
                .hasMessage((MessageCode.INVALID_INPUT_FORMAT_NUMBERS.message()));
    }
}