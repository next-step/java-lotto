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
    @DisplayName("숫자가 있는지 확인")
    void testContain() {
        //given
        int number = 1;
        //when
        lotto.addNumber(number);
        //then
        assertThat(lotto.isContain(number)).isTrue();
    }

    @Test
    @DisplayName("숫자를 모두 선택하지 않은 경우")
    void testSelectNotComplete() {
        //given
        int number = 1;
        //when
        lotto.addNumber(number);
        //then
        assertThat(lotto.isSelectComplete()).isFalse();
    }

    @Test
    @DisplayName("숫자를 모두 선택한 경우")
    void testSelectComplete() {
        //given
        //when
        for (int i = 0; i < 6; i++) {
            lotto.addNumber(i);
        }
        //then
        assertThat(lotto.isSelectComplete()).isTrue();
    }
}