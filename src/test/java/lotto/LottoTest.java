package lotto;

import lotto.domain.*;
import lotto.view.ResultView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또번호생성() {
        Lottos lottos = new Lottos(3);
        ResultView.resultLottoNumber(3, lottos);
        assertThat(lottos.toString().split("],").length).isEqualTo(3);

    }

}