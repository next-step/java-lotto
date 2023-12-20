package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 파라미터로 Sting이 들어왔을 때, 값을 잘 분리하는지 확인한다.")
    void test1() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        for (int i = 1; i < 7; i++) {
            assertTrue(lottoNumbers.contains(new LottoNumber(i)));
        }
    }

    @Test
    @DisplayName("로또 번호열이 6개가 아닌 경우 exception을 발생시킨다.")
    void test2() {
        LottoNumbers toTestLottoNumber1 = new LottoNumbers("1,2,3,4,5");
        LottoNumbers toTestLottoNumber2 = new LottoNumbers("1,2,3,4,5,6,7");
        String expectingMessage = "6개 이상의 숫자를 입력해주세요.";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> toTestLottoNumber1.validate())
            .withMessageMatching(expectingMessage);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> toTestLottoNumber2.validate())
            .withMessageMatching(expectingMessage);
    }

    @Test
    @DisplayName("로또 번호열에 중복되는 번호가 있는 경우 exception을 발생시킨다.")
    void test3() {
        LottoNumbers toTestLottoNumber = new LottoNumbers("1,2,3,4,5,5");
        String expectingMessage = "중복되는 값이 있습니다.";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> toTestLottoNumber.validate())
            .withMessageMatching(expectingMessage);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호열과 몇개의 번호가 일치하는지 찾는다.")
    @CsvSource(value = { "1,2,3,7,8,9:3", "1,2,3,4,8,9:4", "1,2,3,4,5,9:5" }, delimiter = ':')
    void test4(String toTestNumber, int expectingResult) {
        LottoNumbers winningNumber = new LottoNumbers("1,2,3,4,5,6");

        assertThat(winningNumber.countDuplicateNumber(new LottoNumbers(toTestNumber)))
            .isEqualTo(expectingResult);
    }
}
