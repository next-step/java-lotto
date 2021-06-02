package lotto.view;

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
        String inputLottoNumber = "1,5,8,21,23,31,34";
        LottoNumbers lottoNumbers = inputView.parsingInputLottoNumbers(inputLottoNumber);
        assertThat(lottoNumbers.contains(1)).isTrue();
        assertThat(lottoNumbers.contains(5)).isTrue();
        assertThat(lottoNumbers.contains(23)).isTrue();
    }
/*    @Test
    public void validateInputMoneyForLotto_로또구매입력금액이_로또가격보다작은경우_검증() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateInputMoneyForLotto(700))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(MessageCode.INVALID_LOTTO_MIN_PRICE.message());
    }

    @Test
    public void validateInputCountForManualLotto_수동로또구매갯수_음수입력_검증() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateInputCountForManualLotto(-1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(MessageCode.INVALID_MANUAL_LOTTO_COUNT.message());
    }*/

}