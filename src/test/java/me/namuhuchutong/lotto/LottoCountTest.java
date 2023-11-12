package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    @DisplayName("일치하는 번호 수는 음수일 수 없다.")
    @Test
    void matching_numbers_should_not_be_negative() {
        //given
        long given = -1;

        //when, then
        assertThatThrownBy(() -> new LottoCount(given))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
