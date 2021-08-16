package app.domain.lotto;

import app.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerLottoTest {

    @DisplayName("로또번호 맞추기")
    @Test
    void matchLotto(){
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        WinnerLotto winner = WinnerLotto.of(Lotto.from(Arrays.asList(1,2,3,4,5,6)),LottoNum.of(7));
        assertThat(winner.match(lotto)).isEqualTo(Winning.FIRST);
    }
    @DisplayName("2등번호 체크하기")
    @Test
    void matchSecond(){
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,7));
        WinnerLotto winner = WinnerLotto.of(Lotto.from(Arrays.asList(1,2,3,4,5,6)),LottoNum.of(7));
        assertThat(winner.match(lotto)).isEqualTo(Winning.SECOND);
    }

}