package lotto;

import lotto.domain.LottoMoney;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    @ParameterizedTest
    @DisplayName("로또를 팔았을 경우 입력한 로또의 장수와 판매한 로또의 장수가 일치 하는 지 테스트")
    @MethodSource("provideNumberOfLotto")
    void LottoCountIsEqualWithNumberOfAutoInput(LottoMoney moneyInput, List<String> manualInput, int expected) {
        int actual = LottoStore.sellLottoTicket(moneyInput, manualInput).size();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberOfLotto() {
        return Stream.of(
                Arguments.of(new LottoMoney(BigDecimal.valueOf(5000)), Collections.emptyList(), 5),
                Arguments.of(new LottoMoney(BigDecimal.valueOf(15000)), Collections.emptyList(), 15),
                Arguments.of(new LottoMoney(BigDecimal.valueOf(1000)), Collections.emptyList(), 1)
        );
    }

    @ParameterizedTest
    @DisplayName("지불한 돈에 비해 구매 요청한 수동 로또의 장수가 많을 경우 Fail")
    @MethodSource("provideInvalidLotto")
    void FailIfNumberOfManualBiggerThanTotalBuyingTicket(LottoMoney moneyInput, List<String> manualInput) {

        assertThatThrownBy(() -> LottoStore.sellLottoTicket(moneyInput, manualInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidLotto() {
        return Stream.of(
                Arguments.of(new LottoMoney(BigDecimal.valueOf(1000)), Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6")),
                Arguments.of(new LottoMoney(BigDecimal.valueOf(2000)), Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"))
        );
    }

}
