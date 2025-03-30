package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 500, 999})
    void generateWithInvalidMoney(int money) {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when & then
        assertThatThrownBy(() -> lottoGenerator.generate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1500, 2001})
    void generateWithNotThousandUnit(int money) {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when & then
        assertThatThrownBy(() -> lottoGenerator.generate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 해당하는 로또를 발급한다.")
    @Test
    void generate() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        int money = 5000;

        // when
        List<Lotto> lottos = lottoGenerator.generate(money);

        // then
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("발급된 로또의 숫자는 정렬되어 있어야 한다.")
    @Test
    void generateSortedLotto() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        int money = 1000;

        // when
        List<Lotto> lottos = lottoGenerator.generate(money);
        Lotto lotto = lottos.get(0);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).isSorted();
    }
}
