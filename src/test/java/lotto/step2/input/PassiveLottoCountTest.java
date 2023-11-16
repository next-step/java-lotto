package lotto.step2.input;

import lotto.step2.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.step2.input.PassiveLottoCount.MIN_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PassiveLottoCountTest {

    private final int maxPassiveLottoCount = 150;

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 15, 100})
    @DisplayName("생성자로 범위내의 수동으로 구매할 로또 수가 입력되면, 생성된 객체는 수동으로 구매할 로또 수를 가지고 있다.")
    void testPassiveLottoCountConstructor(final int userCountInput) {
        //given
        PassiveLottoCount passiveLottoCount = new PassiveLottoCount(userCountInput, maxPassiveLottoCount);

        //when
        final int value = passiveLottoCount.getValue();

        //then
        assertThat(value).isEqualTo(userCountInput);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    @DisplayName("생성자로 0개 이하의 수동으로 구매할 로또 수가 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPassiveLottoCountIsLessThanZeroAndIsEqualToZero(final int userCountInput) {
        //given, when, then
        assertThatThrownBy(() -> new PassiveLottoCount(userCountInput, maxPassiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be between " + MIN_VALUE + " and " + maxPassiveLottoCount);
    }

    @Test
    @DisplayName("생성자로 최대 수동으로 구매할 로또 수보다 더 큰 값이 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPassiveLottoCountIsGreaterThanMaxValue() {
        //given, when, then
        assertThatThrownBy(() -> new PassiveLottoCount(maxPassiveLottoCount + 1, maxPassiveLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passiveLottoCount must be between " + MIN_VALUE + " and " + maxPassiveLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 15})
    @DisplayName("isSameWithListSize()를 사용하면, 메서드의 입력으로 들어온 List의 사이즈와 수동으로 구매할 로또 수를 비교한다.")
    void testPassiveLottoCountIsSameWithListSize(final int userCountInput) {
        //given
        PassiveLottoCount passiveLottoCount = new PassiveLottoCount(userCountInput, maxPassiveLottoCount);
        List<Lotto> lottos = generatePassiveLottos(userCountInput);

        //when
        boolean isSameWithListSize = passiveLottoCount.isSameWithListSize(lottos);

        //then
        assertThat(isSameWithListSize).isTrue();
    }

    private List<Lotto> generatePassiveLottos(final int passiveLottoCount) {
        final List<Lotto> passiveLottos = new ArrayList<>();

        for (int i = 0; i < passiveLottoCount; i++) {
            passiveLottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        }

        return passiveLottos;
    }
}
