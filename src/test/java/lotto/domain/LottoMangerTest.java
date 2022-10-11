package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.strategy.FrontExtractStrategy;
import org.junit.jupiter.api.Test;

class LottoMangerTest {

    @Test
    void 로또_맞춘_갯수_체크() {
        LottoBox lottoBox = LottoManger.createLottoBox(3, new FrontExtractStrategy());
        Lotto correctLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoBox.retrieveCorrectNum(correctLotto))
                .containsExactly(6, 6, 6);
    }

    @Test
    void 로또_반절_맞춘_갯수_체크() {
        LottoBox lottoBox = LottoManger.createLottoBox(3, new FrontExtractStrategy());
        Lotto correctLotto = new Lotto(List.of(1, 11, 12, 7, 2, 5));
        assertThat(lottoBox.retrieveCorrectNum(correctLotto))
                .containsExactly(3, 3, 3);
    }
}