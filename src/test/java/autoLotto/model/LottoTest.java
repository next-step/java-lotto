package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static autoLotto.model.LottoConstants.INVALID_LOTTO_NUMBERS;
import static autoLotto.model.LottoConstants.VALID_LOTTO_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final List<Integer> VALID_NUMBERS = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    private static final String VALID_NUMBERS_AS_STRING = "1,2,3,4,5,6";

    private static final List<Integer> INVALID_NUMBERS = new ArrayList<>(Arrays.asList(-1,2,3,5,111));
    private static final String INVALID_NUMBERS_AS_STRING = "-1,2,3,4,5,111";

    private static final List<Integer> INVALID_COUNT_OF_NUMBERS = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
    private static final String INVALID_COUNT_OF_NUMBERS_AS_STRING = "1,2,3,4,5,6,7";

    @Test
    @DisplayName("List<Integer> 인자로 로또 생성 성공")
    void testLotto_ValidNumbers_ShouldConstructCorrectLotto() {
        // when
        Lotto lotto = new Lotto(VALID_NUMBERS);
        List<Integer> lottoNumbers = lotto.getLotto();

        // then
        for (int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(VALID_NUMBERS.get(i));
        }
    }

    @Test
    @DisplayName("List<Integer> 인자로 로또 생성 실패 : 잘못된 값")
    void testLotto_InValidNumbers_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new Lotto(INVALID_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("List<Integer> 인자로 로또 생성 실패 : 잘못된 번호 개수")
    void testLotto_InValidCountOfNumbers_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new Lotto(INVALID_COUNT_OF_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("String 인자로 로또 생성 성공")
    void testLotto_ValidNumbersAsString_ShouldConstructCorrectLotto() {
        // when
        Lotto lotto = new Lotto(VALID_NUMBERS_AS_STRING);
        List<Integer> lottoNumbers = lotto.getLotto();

        // then
        for (int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(VALID_NUMBERS.get(i));
        }
    }

    @Test
    @DisplayName("String 인자로 로또 생성 실패 : 잘못된 값")
    void testLotto_InValidNumbersAsString_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new Lotto(INVALID_NUMBERS_AS_STRING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("String 인자로 로또 생성 실패 : 잘못된 번호 개수")
    void testLotto_InValidCountOfNumbersAsString_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new Lotto(INVALID_COUNT_OF_NUMBERS_AS_STRING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

}
