package lotto.view;

import lotto.common.MessageCode;
import lotto.domain.LottoNumbers;
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
        assertThat(lottoNumbers[0].contains(1)).isTrue();
        assertThat(lottoNumbers[0].contains(2)).isTrue();
        assertThat(lottoNumbers[0].contains(3)).isTrue();
        assertThat(lottoNumbers[0].contains(4)).isTrue();
    }

    @Test
    public void parsingInputLottoNumbers_String파싱해서_LottoNumber로_변환_검증() {
        InputView inputView = new InputView();
        String inputLottoNumber = "1,5,8,21,23,31";
        LottoNumbers lottoNumbers = inputView.parsingInputLottoNumbers(inputLottoNumber);
        assertThat(lottoNumbers.contains(1)).isTrue();
        assertThat(lottoNumbers.contains(5)).isTrue();
        assertThat(lottoNumbers.contains(23)).isTrue();
    }

    @Test
    public void parsingInputLottoNumbers_exception_로또개수초과_검증() {
        InputView inputView = new InputView();
        String inputLottoNumber = "1,5,8,21,23,31,34";
        assertThatThrownBy( ()-> inputView.parsingInputLottoNumbers(inputLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage((MessageCode.INVALID_OVER_LOTTO_NUMBERS.message()));
    }

    @Test
    public void parsingInputLottoNumbers_exception_로또개수6보다적은오류_검증() {
        InputView inputView = new InputView();
        String inputLottoNumber = "1,5,8,21,23";
        assertThatThrownBy( ()-> inputView.parsingInputLottoNumbers(inputLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage((MessageCode.INVALID_INPUT_LOTTO_NUMBER_COUNT.message()));
    }
}