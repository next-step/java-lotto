package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoGameTest {
    @BeforeEach
    void init() {
        String input = "14000 1, 2, 3, 4, 5, 6 7"; // 1000000000
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액과 당첨 번호로 로또 게임을 실행한다.")
    @Test
    public void playLotto() {
        LottoGame.playLotto();
    }
}
