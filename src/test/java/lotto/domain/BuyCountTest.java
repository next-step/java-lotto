package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BuyCountTest {

    @DisplayName("로또 구입 금액 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12000", "1000"})
    void of_money(String money) {
        assertThatCode(() -> BuyCount.fromMoney(money))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 구입 개수 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"50", "-1"})
    void of_count(int count) {
        assertThatCode(() -> BuyCount.from(count))
                .doesNotThrowAnyException();

        assertThat(BuyCount.from(count).get()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액 1000단위 아닌 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"333", "10", "11001"})
    void of_invalid_money_unit(String money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BuyCount.fromMoney(money))
                .withMessage(LottoExceptionMessage.INVALID_MONEY_UNIT);
    }

    @DisplayName("로또 구입 금액 숫자 아닌 문자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"O", "얼마샀더라", "흠"})
    void of_not_number(String money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BuyCount.fromMoney(money))
                .withMessage("숫자를 제대로 입력해주세요.");
    }

    @DisplayName("로또 구매 개수 - 구매 가능 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4000,true", "333000,true", "1000,true", "0,false"})
    void getBuyCount(String lottoMoney, boolean canBuy) {
        BuyCount buyCount = BuyCount.fromMoney(lottoMoney);

        boolean actual = buyCount.canBuy();

        assertThat(actual).isEqualTo(canBuy);
    }

    @DisplayName("로또 개수 빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:1:3", "100:-1:101", "320:8:312"}, delimiter = ':')
    void subtract_number(int count, int subtractingCount, int expectedResult) {
        BuyCount buyCount = BuyCount.from(count);

        BuyCount actualBuyCount = buyCount.subtract(subtractingCount);

        assertThat(actualBuyCount).isEqualTo(BuyCount.from(expectedResult));
    }
}
