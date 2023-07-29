package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"10000", "9999", "100000"})
    @DisplayName("받은 금액만큼 로또를 생성하는지 테스트")
    void lottoGenerator_amountToLotto(final String value) {
        /* given */
        final Money money = new Money(value);
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        /* when */
        BoughtResult boughtResult = lottoGenerator.generate(money);
        BoughtLottos boughtLottos = boughtResult.getBoughtLottos();

        /* then */
        assertThat(boughtLottos.getLottos()).hasSize(Integer.parseInt(value) / Lotto.PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("받은 개수만큼 로또를 생성하는지 테스트")
    void lottoGenerator_countToLotto(final int count) {
        /* given */
        final Money money = new Money(100_000);
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        /* when */
        BoughtResult boughtResult = lottoGenerator.generate(money, count);
        BoughtLottos boughtLottos = boughtResult.getBoughtLottos();

        /* then */
        assertThat(boughtLottos.getLottos()).hasSize(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("로또를 생성하고 거스름돈을 제대로 반환하는지 테스트")
    void lottoGenerator_change(final int count) {
        /* given */
        final Money money = new Money(100_000);
        final Money expected = new Money(100_000 - Lotto.PRICE * count);
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        /* when */
        BoughtResult boughtResult = lottoGenerator.generate(money, count);
        Money change = boughtResult.getChange();

        /* then */
        assertThat(change).isEqualTo(expected);
    }

    @Test
    @DisplayName("적절하게 shuffle이 되는지 확인하는 테스트")
    void lottoGenerator_generate() {
        /* given */
        final Money money = new Money("2000");

        /* when */
        final LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        BoughtResult boughtResult = lottoGenerator.generate(money, new SequenceLottoGenerateStrategy());
        BoughtLottos boughtLottos = boughtResult.getBoughtLottos();

        /* then */
        assertThat(boughtLottos.getLottos()).containsExactlyInAnyOrder(
                new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")),
                new Lotto(LottoTest.getBalls("7", "8", "9", "10", "11", "12"))
        );
    }
}
