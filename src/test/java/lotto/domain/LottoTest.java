package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoFixture.lottoNumbersFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    void 로또자동발급확인() {
        Lotto lotto = Lotto.autoGenerate();
        assertThat(lotto.numbers().getValues().size()).isEqualTo(6);
        assertAll(
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(0))).isTrue(),
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(1))).isTrue(),
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(2))).isTrue(),
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(3))).isTrue(),
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(4))).isTrue(),
                () -> assertThat(LottoNumbers.ALL_NUMBERS.contains(lotto.numbers().find(5))).isTrue()
        );
    }

    @Test
    void 로또수동발급확인() {
        Lotto lotto = Lotto.manualGenerate(lottoNumbersFixture("33, 36, 31, 34, 35, 32"));
        LottoNumbers expectedLottoNumbers = lottoNumbersFixture("31, 32, 33, 34, 35, 36");
        assertAll(
                () -> assertThat(lotto.numbers().getValues().size()).isEqualTo(6),
                () -> assertThat(lotto.numbers()).isEqualTo(expectedLottoNumbers)
        );
    }
}
