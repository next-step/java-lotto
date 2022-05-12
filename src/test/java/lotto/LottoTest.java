package lotto;

import lotto.domain.Lotto;
import lotto.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또번호생성() {
        Lotto lotto = new Lotto(3);
        assertThat(lotto.toString().split("],").length).isEqualTo(3);
    }

    @Test
    void print() {
        Lotto lotto = new Lotto(4);
        ResultView.resultLottoNumber(4, lotto);
    }
}
