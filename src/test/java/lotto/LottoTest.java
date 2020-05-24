package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;


public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트(){
        assertThatCode(() -> new Lotto()).doesNotThrowAnyException();
    }

}
