package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_한_장의_가격은_1000원이다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.PRICE).isEqualTo(1000);
    }

    @Test
    void 로또는_1부터_45까지의_숫자_중에서_6개를_골라_발행한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.numbers).allMatch(num -> num <= 45)
                .allMatch(num -> num >= 1);
    }
}
