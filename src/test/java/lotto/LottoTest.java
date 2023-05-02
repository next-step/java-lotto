package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class LottoTest {

    @AfterEach
    public void afterEach() {
        System.setIn(System.in);
    }

    private void consoleInput(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }

    @DisplayName("로또앱을 실행하는 동작테스트를 자동화한다")
    @Test
    public void lottoApplicationContextTest() {
        //given
        consoleInput(
                "99000" + System.lineSeparator() +
                        //수동 구매 수
                        "4" + System.lineSeparator() +
                        // 수동구매 번호
                        "1, 2, 3, 4, 5, 6" + System.lineSeparator() +
                        "8, 21, 23, 41, 42, 43" + System.lineSeparator() +
                        "3, 5, 11, 16, 32, 38" + System.lineSeparator() +
                        "7, 11, 16, 35, 36, 44" + System.lineSeparator() +
                        //지난주 당첨번호
                        "7, 11, 16, 35, 36, 44" + System.lineSeparator() +
                        //보너스볼
                        "7"
        );
        //when
        //then
        Lotto.main(new String[]{});
    }
}