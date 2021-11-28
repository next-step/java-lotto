package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoServiceTest {
    @BeforeEach
    void init() {
        String input = "14000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액 14000을 입력했을때 자동 로또 14장을 발급한다.")
    @Test
    public void playLotto() {
        LottoService lottoService = new LottoService();
        lottoService.playLotto();
    }
}
