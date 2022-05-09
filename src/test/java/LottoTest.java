import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또번호생성() {
        Lotto lotto = new Lotto(3000);
        assertThat(lotto.generateLottoNumber().size()).isEqulto(3);
    }

    @Test
    void 당첨자확인() {
        Lotto lotto = new Lotto(3000);
        List<An>
        assertThat(lotto.isNumber)
    }


}
