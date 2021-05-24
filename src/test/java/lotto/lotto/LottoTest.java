package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.error.ErrorMessage;
import lotto.shop.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private Lotto lotto;

    @Test
    @DisplayName("같은 숫자를 넣었을 때")
    void testContain() {
        //given
        //when
        lotto = new Lotto(1,1,1,1,1,1);
        //then
        assertThat(lotto.isSelectComplete()).isFalse();
    }

    @Test
    @DisplayName("숫자를 모두 선택하지 않은 경우")
    void testSelectNotComplete() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lotto = new Lotto(1,2,3);
                }).withMessageContaining(ErrorMessage.INVALID_LOTTO_COUNT);
    }

    @Test
    @DisplayName("숫자를 모두 선택한 경우")
    void testSelectComplete() {
        //given
        //when
        lotto = new Lotto(1,2,3,4,5,6);
        //then
        assertThat(lotto.isSelectComplete()).isTrue();
    }
}