import domain.AutoNumberStrategy;
import domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또생성시_6개숫자_테스트() {
        Lotto lotto = new Lotto(new AutoNumberStrategy());
        assertThat(lotto.getNumbers().getValues().size()).isEqualTo(6);
    }
}
