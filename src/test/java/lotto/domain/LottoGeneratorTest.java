package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"10000", "9999", "100000"})
    @DisplayName("받은 금액만큼 로또를 생성하는지 테스트")
    void lottoGenerator_amountToLotto(final String value) {
        /* given */
        final Money money = new Money(value);

        /* when */
        LottoGenerator lottoGenerator = new LottoGenerator();
        BoughtLottos boughtLottos = lottoGenerator.generate(money);

        /* then */
        assertThat(boughtLottos.getLottosNumbers()).hasSize(Integer.parseInt(value) / Lotto.PRICE);
    }

    @Test
    @DisplayName("받은 금액이 로또의 가격보다 적은 경우 테스트")
    void lottoGenerator_lowerThanLottoPrice() {
        assertThatThrownBy(() -> {
            LottoGenerator lottoGenerator = new LottoGenerator();
            lottoGenerator.generate(new Money("999"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("받은 금액이 하루 구입 가능한 총 로또 가격보다 많은 경우 테스트")
    void lottoGenerator_greaterThanLottoTotalPrice() {
        assertThatThrownBy(() -> {
            LottoGenerator lottoGenerator = new LottoGenerator();
            lottoGenerator.generate(new Money("100001"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("적절하게 shuffle이 되는지 확인하는 테스트")
    void lottoGenerator_generate() {
        /* given */
        final Money money = new Money("2000");

        /* when */
        final LottoGenerator lottoGenerator = new LottoGenerator(
                new SequenceLottoGenerateStrategy());
        BoughtLottos boughtLottos = lottoGenerator.generate(money);

        /* then */
        assertThat(boughtLottos.getLottosNumbers()).containsExactlyInAnyOrder(
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(List.of(7, 8, 9, 10, 11, 12))
        );
    }
}
