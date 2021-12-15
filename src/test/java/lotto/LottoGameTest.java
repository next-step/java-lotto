package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoGameTest {
    @BeforeEach
    void init() {
        Lotto numbers = new Lotto();
        String numbersString = numbers.getNumbers().toString();
        String prizeNumbers = numbersString.substring(1, numbersString.length() - 1);
        System.out.println(prizeNumbers);
        String input = "14000 " + prizeNumbers; // 1000000000
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액과 당첨 번호로 로또 게임을 실행한다.")
    @Test
    public void playLotto() {
        LottoGame.playLotto();
    }
}
