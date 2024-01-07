package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;

class LottoTest {

    @Test
    @DisplayName("Lotto 파라미터로 Sting이 들어왔을 때, 값을 잘 분리하는지 확인한다.")
    void test1() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        for (int i = 1; i < 7; i++) {
            assertTrue(lotto.contains(LottoNumber.of(i)));
        }
    }

    @Test
    @DisplayName("Lotto 파라미터로 Integer로 들어왔을 때, Lotto가 잘 만들어지는지 확인한다.")
    void test2() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        for (int i = 1; i < 7; i++) {
            assertTrue(lotto.contains(LottoNumber.of(i)));
        }
    }

    @Test
    @DisplayName("로또 번호열이 6개가 아닌 경우 exception을 발생시킨다.")
    void test3() {
        String expectingMessage = "숫자 6개 만 입력해주세요";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto("1,2,3,4,5"))
            .withMessageMatching(expectingMessage);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
            .withMessageMatching(expectingMessage);
    }


    @ParameterizedTest
    @DisplayName("당첨 번호열과 몇개의 번호가 일치하는지 찾는다.")
    @CsvSource(value = { "1,2,3,7,8,9:3", "1,2,3,4,8,9:4", "1,2,3,4,5,9:5" }, delimiter = ':')
    void test4(String toTestNumber, int expectingResult) {
        Lotto winningNumber = new Lotto("1,2,3,4,5,6");

        assertThat(winningNumber.countDuplicateNumber(new Lotto(toTestNumber)))
            .isEqualTo(expectingResult);
    }
}
