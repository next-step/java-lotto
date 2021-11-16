package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoTest {

    @Test
    void 랜덤한_숫자_6자리로_구성된_로또를_생성한다() {
        //given
        Lotto lotto = Lotto.generate();
        //when
        List<Number> lottoNumbers = lotto.getLottoNumbers();
        //then
        assertNotNull(lotto);
        assertEquals(6, lottoNumbers.size());
    }
}
