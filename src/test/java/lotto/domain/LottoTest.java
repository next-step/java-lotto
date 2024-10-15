package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 중복 번호 체크")
    void 로또_중복_체크(){
        assertThatThrownBy(()-> new Lotto("7,8,9,9,10,11"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 넘버가 없으면 false 반환")
    void 보너스_번호_없음() {
        Lotto lotto = new Lotto("7,8,9,4,5,6");
        assertThat(lotto.isMatchBonus(new LottoNum(10))).isFalse();
    }

    @Test
    @DisplayName("보너스 넘버가 있으면 true 반환")
    void 보너스_번호_있음() {
        Lotto lotto = new Lotto("7,8,9,4,5,6");
        assertThat(lotto.isMatchBonus(new LottoNum(7))).isTrue();
    }

    @Test
    @DisplayName("당첨 로또와 일치하는 개수 추출")
    void 당첨_로또와_일치하는_개수_추출() {
        Lotto winner = new Lotto("1,2,3,4,5,6");
        Lotto lotto = new Lotto("7,8,9,4,5,6");
        assertThat(lotto.compareWinningNumber(winner)).isEqualTo(3);
    }

}
