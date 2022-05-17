package lotto.domain;

import lotto.exceptions.DuplicatedNumbersException;
import lotto.exceptions.InvalidLottoByHandLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exceptions.DuplicatedNumbersException.DUPLICATED_NUMBERS;
import static lotto.exceptions.InvalidLottoByHandLengthException.INVALID_LOTTO_BY_HAND_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @Test
    @DisplayName("수동 Lotto 생성 확인")
    void createByHand() {
        Lotto lotto = new Lotto(new int[]{1, 5, 13, 24, 35, 45});
        assertThat(lotto).isEqualTo(new Lotto(new int[]{1, 5, 13, 24, 35, 45}));
    }

    @Test
    @DisplayName("로또 번호 확인")
    void hasNumbers() {
        Lotto lotto = new Lotto(new int[]{1, 5, 13, 24, 35, 45});
        assertThat(lotto.hasNumbers(LottoNumber.of(1))).isTrue();
    }

    @Test
    @DisplayName("수동 로또 중복 번호가 있을 경우 DuplicatedNumbersException")
    void createDuplicated() {
        assertThatExceptionOfType(DuplicatedNumbersException.class)
                .isThrownBy(() -> new Lotto(new int[]{1, 1, 13, 24, 35, 45}))
                .withMessage(DUPLICATED_NUMBERS);
    }

    @Test
    @DisplayName("수동 로또 개수가 6개가 아닐 경우 InvalidLottoByHandLengthException")
    void createLengthException() {
        assertThatExceptionOfType(InvalidLottoByHandLengthException.class)
                .isThrownBy(() -> new Lotto(new int[]{1, 2, 13, 24, 35}))
                .withMessage(INVALID_LOTTO_BY_HAND_LENGTH);
    }

}