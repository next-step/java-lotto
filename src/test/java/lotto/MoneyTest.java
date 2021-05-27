package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoTicketCount;
import lotto.domain.Money;

public class MoneyTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        // given
        Money money = new Money("1000");
        // when & then
        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test
    @DisplayName("금액 유효성 테스트")
    void validate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(900));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @Test
    @DisplayName("구매 가능 로또 수 반환 테스트")
    void countOfLotto() {
        // given
        Money money = new Money(14000);
        // when & then
        assertThat(money.countOfLotto()).isEqualTo(14);
    }

    @ParameterizedTest(name = "복권 수동 구매 수에 따른 자동 구매 수 테스트")
    @CsvSource(value = {"1:9", "5:5", "10:0"}, delimiter = ':')
    void manual(int input, int expected) {
        // given
        Money lottoMoney = new Money(10000);
        // when & then
        assertThat(lottoMoney.purchasableCount(new LottoTicketCount(input))).isEqualTo(expected);
    }
}

