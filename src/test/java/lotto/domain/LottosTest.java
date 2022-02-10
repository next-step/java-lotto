package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
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
        assertThat(autoLottos.size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("수동 로또를 생성한다.")
    @Test
    void Given_로또_번호_리스트_AND_예산_When_수동로또_생성_Then_로또_번호의_수_만큼_생성() {
        // given & when
        Lottos manualLottos = Lottos.createManualLottos(
                Arrays.asList("1,2,3,4,5,6", "11,12,13,14,15,16"), new Budget("5000"));

        // then
        assertThat(manualLottos.size()).isEqualTo(2);
    }

    @DisplayName("수동 로또를 생성할 때 예산이 부족하면 예외가 발생한다.")
    @Test
    void Given_로또_번호_리스트_AND_부족한_예산_When_수동로또_생성_Then_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> Lottos.createManualLottos(
                Arrays.asList("1,2,3,4,5,6"), new Budget("100")));
    }
}
