package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("성공 : 로또번호는 6개가 존재한다 (6개 입력)")
    void length_success() {
        assertThatCode(() ->
                new LottoFactory(List.of("1", "5", "10", "12", "16", "33")).stringToLotto()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("실패 : 로또번호는 6개가 존재한다 (7개 입력)")
    void length_fail2() {
        assertThatThrownBy(() -> new LottoFactory(List.of("1", "3","5", "10", "12", "16", "33")).stringToLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }
}