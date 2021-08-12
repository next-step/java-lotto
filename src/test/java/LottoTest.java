import domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또생성시_6개숫자_테스트() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).isEqualTo(null);
    }
}
