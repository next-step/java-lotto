package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.LottoNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void create(){
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("로또 번호는 6개 이다.")
    void invalid_lotto_size(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 사이의 숫자이다.")
    void invalid_lotto_numbers(){
        assertThatThrownBy(() -> new Lotto(List.of(0,1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 일치시 1등")
    void first_lotto(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(userLotto.match(winningLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치시 2등")
    void second_lotto(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,7));

        assertThat(userLotto.match(winningLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("4개 일치시 3등")
    void third_lotto(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,7,8));

        assertThat(userLotto.match(winningLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("3개 일치시 4등")
    void fourth_lotto(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,7,8,9));

        assertThat(userLotto.match(winningLotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("2개 이하 일치시 꽝")
    void fail_lotto(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,7,8,9,10));

        assertThat(userLotto.match(winningLotto)).isEqualTo(Rank.FAIL);
    }
}
