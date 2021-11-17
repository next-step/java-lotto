package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 로또를_생성한다() {
        //given
        //when
        //then
        assertEquals(Lotto.of(new String[]{"1", "2", "3", "4", "5", "6"}),
                Lotto.of(new String[]{"1", "2", "3", "4", "5", "6"}));
    }

    @Test
    void 로또_번호를_비교_한다() {
        //given
        Lotto lotto = Lotto.of(new String[]{"1", "2", "3", "4", "5", "6"});
        Lotto targetLotto = Lotto.of(new String[]{"1", "2", "3", "24", "5", "26"});
        //when
        int matchCount = lotto.match(targetLotto);
        //then
        assertThat(matchCount).isEqualTo(4);
    }
}
