package lotto.service;

import lotto.model.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberPickerTest {

    @Test
    void shouldPickRightNumber() {
        List<LottoBall> result = LottoNumberPicker.pick(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertThat(result.size()).isEqualTo(LottoNumberPicker.LOTTO_LENGTH);
        assertThat(result.get(LottoNumberPicker.LOTTO_LENGTH - 1)).isEqualTo(new LottoBall(6));
    }

    @Test
    @DisplayName("중복된 추첨번호는 예외를 터트려야 합니다.")
    void shouldValidateLottoBall() {
        assertThrows(IllegalArgumentException.class, () -> LottoNumberPicker.pick(List.of(1, 2, 1, 2, 2, 3)));
    }

}
