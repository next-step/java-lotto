package lotto;

import lotto.domain.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @BeforeEach
    void init() {
        Numbers numbers = new Numbers();
        String numbersString = numbers.getNumbers().toString();
        String prizeNumbers = numbersString.substring(1, numbersString.length() - 1);
        System.out.println(prizeNumbers);
        String input = "1000000000 " + prizeNumbers;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("구입 금액 1000000000을 입력했을때 자동 로또 1000000장을 발급한다.")
    @Test
    public void playLotto() {
        LottoGame.playLotto();
    }
}
