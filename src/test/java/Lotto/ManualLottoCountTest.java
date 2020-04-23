package Lotto;

import Lotto.domain.ManualLottoCount;
import Lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoCountTest {
    @ParameterizedTest
    @ValueSource(ints = {-4, 10})
    @DisplayName("수동 로또 카운트 에러 발생")
    void errorOnManualLottoCount(final int countOfManualLotto) {
        final Money money = Money.from(5_000);
        assertThatThrownBy(()-> {
            ManualLottoCount.of(countOfManualLotto, money.getLottoCount());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
