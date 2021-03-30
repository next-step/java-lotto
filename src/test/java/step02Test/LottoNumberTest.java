package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.Lotto;
import step02.MakeRandomNumberRule;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("구매한 로또 개수 테스트")
    void buyLottoCount() {
        Lotto lotto = new Lotto();
        assertThat(lotto.buyLotto(4000, new MakeRandomNumberRule())).isEqualTo(4);
    }

}
