package lottery.domain;

import static lottery.domain.constant.LotteryNumberRule.LOTTERY_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LotteryPurchasePriceTest {

    private static final int LOWER_THAN_MIN_PURCHASABLE_PRICE = LOTTERY_PRICE.getRuleNumber() - 1;

    @Test
    @DisplayName("로또 구매 금액 입력시 1000원 이상 입력할 경우 객체 정상 생성")
    void clientLotteryPurchasePriceCreate() {
        assertDoesNotThrow(() -> new LotteryPurchasePrice(LOTTERY_PRICE.getRuleNumber()));
    }

    @Test
    @DisplayName("로또 구매 금액 입력시 1000원 이하 입력할 경우 익셉션 발생")
    void clientLotteryPurchasePriceError() {
        assertThatThrownBy(() -> new LotteryPurchasePrice(LOWER_THAN_MIN_PURCHASABLE_PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 최소 구매 금액은 1000원 이상입니다.");
    }

    @ParameterizedTest(name = "[{index}]금액에 따른 로또 갯수를 리턴한다 {1}")
    @CsvSource(value = {"14000:14","9999:9"},delimiter = ':')
    void returnLotteryPerPrice(int price, int expectedLottery) {
        assertThat(new LotteryPurchasePrice(price).numberOfPlays())
                .isEqualTo(expectedLottery);
    }
}
