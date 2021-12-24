package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoGameTest {
    @BeforeEach
    void init() {
        String input = "14000\n" + // 구입금액 1000000000
                "3\n" + // 수동으로 구매할 로또 수
                "8, 21, 23, 41, 42, 43\n" + // 수동 로또 1
                "3, 5, 11, 16, 32, 38\n" + // 수동 로또 2
                "7, 11, 16, 35, 36, 44\n" + // 수동 로또 3
                "1, 2, 3, 4, 5, 6\n" + // 지난 주 당첨 번호
                "7"; // 보너스 볼
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액과 당첨 번호로 로또 게임을 실행한다.")
    @Test
    public void playLotto() {
        LottoGame.playLotto();
    }
}
