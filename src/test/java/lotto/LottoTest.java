package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class LottoTest {
    @DisplayName("로또앱을 실행하는 동작테스트를 자동화한다")
    @Test
    public void lottoApplicationContextTest() {
        //given
        //when
        Lotto.main(new String[]{});
        //then
        fail();
    }
}