package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoMoneyTest {

    @DisplayName("로또 구입 금액 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12000", "1000"})
    void create(String money) {
        assertThatCode(() -> LottoMoney.of(money))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 구입 금액 비정상 입력 (1000단위) 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"333", "10", "11001"})
    void create_invalid_money_unit(String money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMoney.of(money))
                .withMessage(LottoExceptionMessage.INVALID_MONEY_UNIT);
    }

    @DisplayName("로또 구입 금액 비정상 입력 (숫자 아닌 문자 입력) 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"O", "얼마샀더라", "흠"})
    void create_not_number(String money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMoney.of(money))
                .withMessage("숫자를 제대로 입력해주세요.");
    }

    @DisplayName("로또 구매개수 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4000,4", "333000,333", "1000,1"})
    void getBuyCount(String lottoMoney, int buyCount) {
        assertThat(LottoMoney.of(lottoMoney).getBuyCount()).isEqualTo(buyCount);
    }
}
