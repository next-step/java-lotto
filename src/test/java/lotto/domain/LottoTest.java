package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("숫자 6개가 포함된 로또 1개를 발급한다.")
    void 로또_발급(){
        Lotto lotto = new Lotto();
        assertThat(lotto.numbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또에서 당첨 번호가 일치하는 개수를 반환한다.")
    void 일치하는_당첨번호_개수_반환(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.matchCount(Arrays.asList(1,2,3,7,7,7))).isEqualTo(3);
    }

    @Test
    @DisplayName("로또와 보너스볼의 숫자가 일치하는 확인한다.")
    void 보너스볼_일치_확인(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.isMatchBonusNumber(4)).isTrue();
    }
}
