package lotto;

import lotto.domain.LottoGame;
import lotto.vo.LottoList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @ParameterizedTest
    @MethodSource(value = {"getEmptyCase", "getInvalidCase"})
    void testInvalidCase(final String money) {
        assertThatThrownBy(() -> { new LottoGame(money); })
                .isInstanceOf(RuntimeException.class);
    }

    static Stream<String> getEmptyCase() {
        return Stream.of(null, "", " ");
    }
    static Stream<String> getInvalidCase() {
        return Stream.of("-1", "&");
    }

    @ParameterizedTest
    @CsvSource(value = {"3000=3", "2300=2", "24102=24", "2403=2"}, delimiter = '=')
    void testCreationLotto(final int money, final int count) {
        final int PER_SALE_PRICE = 1000;
        assertThat(new LottoList(money/PER_SALE_PRICE).getCount()).isEqualTo(count);
    }

    @Test
    void testValidationLotto() {

    }

    @Test
    void testAscendingSort() {

    }

    @Test
    void testJudgementLotto() {

    }

    @Test
    void testCalculationPrize() {

    }

    @Test
    void testCalculationEarningsRate() {

    }
}
