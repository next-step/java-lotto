package lotto.step2.domain;

import lotto.step2.input.PassiveLottoCount;
import lotto.step2.input.PurchaseAmount;
import lotto.step2.input.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("구매 금액, 수동으로 구매할 로또 수, 수동으로 구매할 로또 수만큼의 수동으로 구매할 번호를 입력하면, 구매 금액만큼의 로또 List를 발급한다.")
    void testGenerateLottos(final int passvieLottoCount) {
        //given
        final PurchaseAmount purchaseAmountInput = new PurchaseAmount(15000);
        final PassiveLottoCount passiveLottoCountInput = new PassiveLottoCount(passvieLottoCount, purchaseAmountInput.getMaxPassiveLottoCount());
        final List<Lotto> passiveLottos = generatePassiveLottos(passvieLottoCount);
        final UserInput input = new UserInput(purchaseAmountInput, passiveLottoCountInput, passiveLottos);

        //when
        final List<Lotto> lottos = LottoGenerator.generateLottos(input);

        //then
        assertThat(lottos).hasSize(input.getTotalLottosCount());
    }

    private List<Lotto> generatePassiveLottos(final int passiveLottoCount) {
        final List<Lotto> passiveLottos = new ArrayList<>();

        for (int i = 0; i < passiveLottoCount; i++) {
            passiveLottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        }

        return passiveLottos;
    }

    @ParameterizedTest
    @MethodSource("inputTextSplitWithCommaAndWhiteSpace")
    @DisplayName("generatePassiveLottos 메서드의 입력으로 ', '로 구분된 숫자들이 들어오면, 해당 숫자를 가진 Lotto를 만들어서 반환한다.")
    void testGeneratePassiveLottos(final String text, final Lotto expected) {
        //given
        //when
        final Lotto lotto = LottoGenerator.generatePassiveLottos(text);

        //then
        assertThat(lotto).isEqualTo(expected);
    }

    public static Stream<Arguments> inputTextSplitWithCommaAndWhiteSpace() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", new Lotto(Set.of(1, 2, 3, 4, 5, 6))),
                Arguments.of("11, 22, 33, 44, 13, 37", new Lotto(Set.of(11, 22, 33, 44, 13, 37))),
                Arguments.of("9, 12, 18, 28, 38, 43", new Lotto(Set.of(9, 12, 18, 28, 38, 43)))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "숫자", "영어", "!@#"})
    @DisplayName("generatePassiveLottos 메서드의 입력으로 숫자가 아닌 값이 들어오면, NumberFormatException이 발생한다.")
    void throwNumberFormatExceptionWhenGeneratePassiveLottosInputIsNotNumber(final String text) {
        //given, when, then
        assertThatThrownBy(() -> LottoGenerator.generatePassiveLottos(text))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1-2-3-4-5-6", "1.2.3.4.5.6"})
    @DisplayName("generatePassiveLottos 메서드의 입력으로 ', '로 구분된 숫자가 들어오지 않으면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenGeneratePassiveLottosInputIsNotSplitWithCommaAndWhiteSpace(final String text) {
        //given, when, then
        assertThatThrownBy(() -> LottoGenerator.generatePassiveLottos(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5"})
    @DisplayName("generatePassiveLottos 메서드의 입력으로 ', '로 구분된 6개의 숫자가 들어오지 않으면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenGeneratePassiveLottosInputIsNotSixNumberWithCommaAndWhiteSpace(final String text) {
        //given, when, then
        assertThatThrownBy(() -> LottoGenerator.generatePassiveLottos(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 46", "0, 1, 2, 3, 4, 5", "-1, 3, 14, 23, 33, 44"})
    @DisplayName("generatePassiveLottos 메서드의 입력으로 ', '로 구분된 1 ~ 45사이의 6개의 숫자가 들어오지 않으면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenGeneratePassiveLottosInputIsNotNumberBetween1And45(final String text) {
        //given, when, then
        assertThatThrownBy(() -> LottoGenerator.generatePassiveLottos(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
