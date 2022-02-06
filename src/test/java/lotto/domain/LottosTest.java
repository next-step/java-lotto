package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.LottoBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    private static final int PRICE_OF_LOTTO = 1000;

    @DisplayName("구매할 수 있는 개수 만큼 로또가 구매된다.")
    @ValueSource(strings = {"10000", "14500"})
    @ParameterizedTest
    void Given_구매_금액_When_로또자동_생성_Then_구매금액에_맞게_생성(final String budget) {
        // given
        final int numberOfLotto = Integer.parseInt(budget) / PRICE_OF_LOTTO;

        // when
        final Lottos autoLottos = Lottos.createAutoLottos(new Budget(budget));

        // then
        assertThat(autoLottos.get().size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("로또 번호 리스트가 섞인다.")
    @Test
    void When_로또_번호_리스트_섞기_Then_섞기_전과_요소의_순서가_다름() {
        // given
        final ArrayList<String> before = new ArrayList<>(LottoBalls.get());

        // when
        Lottos.createAutoLottos(new Budget("1000"));

        // then
        assertThat(LottoBalls.get()).isNotEqualTo(before);
    }

    @DisplayName("임의의 번호로 발급된 로또가 생성된다. (오름차순으로 정렬)")
    @Test
    void When_로또번호_생성_Then_로또볼_에서_6개를_뽑는다() {
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
