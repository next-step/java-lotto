package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoTest {


    @Test
    @DisplayName("자동로또와 당첨번호 갯수 파악")
    void 자동로또와_당첨번호_갯수파악() {
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto = new Lotto(List.of(1, 5, 6, 7, 8, 9));
        int result = givenLotto.getMatchNumberCount(winLotto);
        assertThat(result).isEqualTo(3);
    }
}
