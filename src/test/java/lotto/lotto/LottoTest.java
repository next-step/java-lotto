package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("같은 숫자를 넣었을 때")
    void testContain() {
        //given
        //when
        for (int i = 1; i < 7; i++) {
            lotto.addNumber(new LottoNumber(1));
        }
        //then
        assertThat(lotto.isSelectComplete()).isFalse();
    }

    @Test
    @DisplayName("숫자를 모두 선택하지 않은 경우")
    void testSelectNotComplete() {
        //given
        int number = 1;
        //when
        lotto.addNumber(new LottoNumber(number));
        //then
        assertThat(lotto.isSelectComplete()).isFalse();
    }

    @Test
    @DisplayName("숫자를 모두 선택한 경우")
    void testSelectComplete() {
        //given
        //when
        for (int i = 1; i < 7; i++) {
            lotto.addNumber(new LottoNumber(i));
        }
        //then
        assertThat(lotto.isSelectComplete()).isTrue();
    }
}