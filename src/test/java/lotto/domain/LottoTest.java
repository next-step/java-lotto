package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    Lotto winningLotto;

    @BeforeEach
    public void setup() {
        winningLotto = Lotto.ofComma("1,2,3,4,5,6");
    }

    @DisplayName("콤마로 구분하여 로또 번호 생성")
    @Test
    public void createOfComma() {
        Lotto lotto = Lotto.ofComma("1,2,3,4,5,6");
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호 6개가 아닐시 에러")
    @Test
    public void invalidLottoSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.ofComma("1,2,3,4,5"));
    }

    @Test
    public void equalsTest() {
        Lotto lotto = Lotto.ofComma("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
    }

    @DisplayName("6개 일치")
    @Test
    public void match() {
        Lotto userLotto = Lotto.ofComma("1,2,3,4,5,6");
        assertThat(winningLotto.match(userLotto)).isEqualTo(6);
    }

    @DisplayName("5개 일치")
    @Test
    public void match_5개() {
        Lotto userLotto = Lotto.ofComma("1,2,3,4,5,7");
        assertThat(winningLotto.match(userLotto)).isEqualTo(5);
    }

    @DisplayName("4개 일치")
    @Test
    public void match_4개() {
        Lotto userLotto = Lotto.ofComma("1,2,3,4,7,8");
        assertThat(winningLotto.match(userLotto)).isEqualTo(4);
    }

    @DisplayName("3개 일치")
    @Test
    public void match_3개() {
        Lotto userLotto = Lotto.ofComma("1,2,3,7,8,9");
        assertThat(winningLotto.match(userLotto)).isEqualTo(3);
    }

}
