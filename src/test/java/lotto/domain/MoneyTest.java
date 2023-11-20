package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("금액이 추가되면 새로운 객체를 생성하는지 확인")
    void 추가금액_객체생성_확인() {
        Money seedMoney = new Money(1000);
        Money addMoney = new Money(2000);
        assertThat(seedMoney.plus(addMoney)).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("금액을 천단위 절삭하여 리턴하는지 확인")
    void 천단위_계산_확인() {
        Money money = new Money(10000);

        assertThat(money.cutByThousand()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value ={"10000:1000:0.1","1000:0:0","1000:1000:1"},delimiter = ':')
    void 수익률_계산_확인(long seed, long prize,float result) {
        Money money = new Money(seed);

        assertThat(money.rateOfreturn(prize)).isEqualTo(result);
    }
}
