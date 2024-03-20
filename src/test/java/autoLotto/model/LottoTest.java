package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final int[] VALID_NUMBERS = {1,2,3,4,5,6};
    private static final int[] INVALID_NUMBERS = {-1,2,3,4,5,111};
    private static final int VALID_LOTTO_LENGTH = 6;
    private static final String INVALID_LOTTO_NUMBERS = "로또 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";

    @Test
    @DisplayName("로또 생성 성공")
    void testLotto_ValidNumbers_ShouldConstructCorrectLotto() {
        // when
        Lotto lotto = new Lotto(VALID_NUMBERS);
        int[] lottoNumbers = lotto.getLotto();

        // then
        for (int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            assertThat(lottoNumbers[i]).isEqualTo(VALID_NUMBERS[i]);
        }
    }

    @Test
    @DisplayName("로또 생성 성공")
    void testLotto_InValidNumbers_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> new Lotto(INVALID_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

}
