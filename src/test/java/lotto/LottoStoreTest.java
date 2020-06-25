package lotto;

import lotto.domain.LottoMoney;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @DisplayName("로또를 팔았을 경우 입력한 돈과 판매한 로또의 장수가 일치 하는 지 테스트")
    @MethodSource("provideValidMoney")
    void LottoCountIsEqualWithMoneyPaid(LottoMoney input, int expected) {
        int actual = LottoStore.sellAutoLottoTicket(input).size();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValidMoney() {
        return Stream.of(
                Arguments.of(new LottoMoney(BigDecimal.valueOf(5000)), 5),
                Arguments.of(new LottoMoney(BigDecimal.valueOf(15000)), 15),
                Arguments.of(new LottoMoney(BigDecimal.valueOf(1000)), 1)
        );
    }
}
