package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("금액 추가 시 계산 후 새로운 객체 생성 확인")
    void 금액_plus() {
        Money startMoney = new Money(1000);
        Money addMoney = new Money(1000);

        assertThat(startMoney.plus(addMoney.find())).isEqualTo(new Money(2000));
    }

    @Test
    @DisplayName("금액 천단위가 아니면 에러를 던짐")
    void 금액_천단위_확인() {
        assertThatThrownBy(() -> new Money(2200)).isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "0:0", "22000:22", "1000000:1000"}, delimiter = ':')
    void 천단위_계산결과_확인(long seed, int result) {
        Money money = new Money(seed);
        assertThat(money.calculateUnits()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:10000:10", "1000:0:0", "50000:5000:0.1", "1000:1000:1"}, delimiter = ':')
    void 수익률_계산결과_확인(long seed, long revenue, float result) {
        Money seedMoney = new Money(seed);
        Money revenusMoney = new Money(revenue);

        assertThat(revenusMoney.rateOfReturn(seedMoney)).isEqualTo(result);
    }

}
