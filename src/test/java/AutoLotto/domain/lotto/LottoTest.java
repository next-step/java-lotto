package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void canCreateLotto() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getLotto().size()).isEqualTo(6);
        assertThat(lotto.getLotto().get(0).getLottoNum()).isLessThanOrEqualTo(45);
        assertThat(lotto.getLotto().get(5).getLottoNum()).isLessThanOrEqualTo(45);
    }
}
