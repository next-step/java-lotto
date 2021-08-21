package lotto.domain;

import lotto.exception.LottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    static Stream<Arguments> countSource() {
        return Stream.of(
                    Arguments.arguments(
                        5, // manualLottoCount
                        new LottoCount(3)
                    ),
                    Arguments.arguments(
                            10,
                            new LottoCount(1)
                    )
                );
    }

    @ParameterizedTest
    @DisplayName("구매할 로또 수 생성 테스트")
    @ValueSource(ints = {-1, -2})
    void createLottoCount(int count) {
        assertThatThrownBy(() -> new LottoCount(count))
                .isInstanceOf(LottoNumberCountException.class);
    }

    @ParameterizedTest
    @DisplayName("구매할 수동 로또수가 구입 금액보다 클때 예외 테스트")
    @MethodSource("countSource")
    void manualCount_bigger_than_money(int manualCount, LottoCount totalCount) {
        assertThatThrownBy(() -> LottoCount.of(manualCount, totalCount))
                .isInstanceOf(LottoNumberCountException.class);
    }

}