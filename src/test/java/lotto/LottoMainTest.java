package lotto;

import lotto.domain.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMainTest {
    @BeforeEach
    void init() {
        String input = "500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액 1000원 미만일 경우 IllegalArgumentException을 throw한다.")
    @Test
    public void playLotto() {
        assertThatThrownBy(() -> LottoGame.playLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 한 장 이상 구매하세요.");
    }
}
