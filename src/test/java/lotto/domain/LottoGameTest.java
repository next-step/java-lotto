package lotto.domain;

import lotto.strategy.MakeAutoLottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    public void 로또개수_동일체크(){
        LottoGame lotto = new LottoGame(3, new MakeAutoLottoNumber());
        assertThat(lotto.getLottos().getLottos().size()).isEqualTo(3);
    }

}
