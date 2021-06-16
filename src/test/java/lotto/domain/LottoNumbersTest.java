package lotto.domain;

import lotto.common.Constant;
import lotto.common.MessageCode;
import lotto.exceptions.DuplicatedLottoNumbersException;
import lotto.exceptions.NumberRangeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    public void LottoNumbers_수동생성_검증() {
        int[] numbers = {1,2,3,4,5,6};
        LottoNumbers lottoNumbers = LottoNumbers.generateManualOf(numbers);
        assertThat(lottoNumbers.contains(new LottoNo(1))).isTrue();
    }

    @Test
    public void LottoNumbers_수동생성_숫자범위_검증() {
        int[] numbers = {1,2,3,4,5,50};
        assertThatThrownBy(() -> LottoNumbers.generateManualOf(numbers))
                .isInstanceOf(NumberRangeException.class).hasMessage(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());
        assertThatThrownBy(() -> LottoNumbers.generateManualOf(numbers))
                .isInstanceOf(NumberRangeException.class).hasMessage(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());
    }

    @Test
    public void LottoNumbers_자동생성_소팅_검증() {
        LottoNumbers lottoNumbers = LottoNumbers.generateAutoOf(LottoNumberGenerator.getInstance());

        for( int i=0; i< Constant.LOTTO_NUMBER_COUNT.value()-1; i++) {
            assertThat(lottoNumbers.lottoNumbers().get(i).lottNo() < lottoNumbers.lottoNumbers().get(i+1).lottNo()).isTrue();
        }
    }

    @Test
    public void LottoNumbers_중복번호_검증() {
        int[] numbers = {1,1,3,4,5,6};
        assertThatThrownBy(() -> LottoNumbers.generateManualOf(numbers))
                .isInstanceOf(DuplicatedLottoNumbersException.class)
                .hasMessage(MessageCode.INVALID_DUP_LOTTO_NUMBERS.message());
    }
}