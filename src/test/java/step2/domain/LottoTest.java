package step2.domain;

import org.junit.jupiter.api.Test;
import step2.strategy.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoTest {

    @Test
    void 랜덤한_숫자_6자리로_구성된_로또를_생성한다() {
        //given
        Lotto lotto = Lotto.generate(new RandomNumberGenerator());
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

    @Test
    void 보너스_번호를_비교_한다() {
        //given
        Lotto lotto = Lotto.of(new String[]{"1", "2", "3", "4", "5", "6"});
        Lotto targetLotto = Lotto.of(new String[]{"1", "2", "3", "24", "5", "26"});
        Number bonusNumber = Number.create(6);
        //when
        int matchCount = lotto.match(targetLotto);
        boolean matchBonus = lotto.matchBonus(bonusNumber);
        //then
        assertThat(matchCount).isEqualTo(4);
        assertThat(matchBonus).isTrue();
    }

    @Test
    void 수동_로또를_생성한다() {
        //given
        String lottoNumbers = "1, 2, 3, 4, 5, 6";
        //when
        String[] splitLottoNumbers = lottoNumbers.split(", ");
        Lotto lotto = Lotto.of(splitLottoNumbers);
        //then
        assertThat(lotto).isEqualTo(Lotto.of(new String[]{"1", "2", "3", "4", "5", "6"}));
    }

    @Test
    void 로또_길이가_6이_아니면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Lotto.of(new String[]{"1", "2", "3", "4", "5"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
