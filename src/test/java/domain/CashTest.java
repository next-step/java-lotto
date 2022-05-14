package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashTest {
    @Test
    void create() {
        //given
        int cashAmount = 3000;

        //when
        Cash result = new Cash(cashAmount);

        //then
        assertThat(result).isEqualTo(new Cash(cashAmount));
    }

    @Test
    void capableLottoCount() {
        //given
        Cash cash = new Cash(3000);

        //when
        int result = cash.capableLottoCount(1000);

        //then
        assertThat(result).isEqualTo(3);
    }
}
