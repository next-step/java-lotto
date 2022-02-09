package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    private static final int PRICE_OF_LOTTO = 1000;

    @DisplayName("금액만큼 로또가 발급된다.")
    @ValueSource(strings = {"10000", "14500"})
    @ParameterizedTest
    void getNumberOfLottos(final String budget) {
        // given
        final int numberOfLotto = Integer.parseInt(budget) / PRICE_OF_LOTTO;

        // when
        final Lottos autoLottos = Lottos.createAutoLottos(new Budget(budget));

        // then
        assertThat(autoLottos.get().size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("로또 번호가 섞인다.")
    @Test
    void shuffle() {
        // given
        final ArrayList<String> before = new ArrayList<>(LottoBalls.get());

        // when
        Lottos.createAutoLottos(new Budget("1000"));

        // then
        assertThat(LottoBalls.get()).isNotEqualTo(before);
    }

    @DisplayName("로또가 생성된다.")
    @Test
    void createAutoLottos() {
        // given
        final int numberOfLotto = Integer.parseInt("1000") / PRICE_OF_LOTTO;

        // when
        final List<Lotto> lottos = Lottos.createAutoLottos(new Budget("1000")).get();

        // then
        List<String> expected = LottoBalls.get().subList(0, 6);
        expected.sort(Comparator.comparingInt(Integer::parseInt));
        assertThat(lottos.get(0).get()).isEqualTo(expected);
    }
}
