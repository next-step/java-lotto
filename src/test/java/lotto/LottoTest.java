package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.fail;

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
        consoleInput("100000"+System.lineSeparator());
        //when
        Lotto.main(new String[]{});
        //then
    }
}