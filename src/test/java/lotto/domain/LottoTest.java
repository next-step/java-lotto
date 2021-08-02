package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    Set<Ball> ballSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 6; i++) {
            ballSet.add(new Ball(i));
        }
    }

    @Test
    @DisplayName("로또 생성")
    void create() {
        Lotto lotto = new Lotto(ballSet);
        assertThat(lotto).isEqualTo(new Lotto(ballSet));
    }

    @Test
    @DisplayName("로또의 숫자 갯수가 6개가 아니면 에러가 발생한다.")
    void validNumberSize() {
        ballSet.add(new Ball(7));

        assertThatThrownBy(() -> new Lotto(ballSet))
                .isInstanceOf(IllegalArgumentException.class);

        ballSet.remove(new Ball(7));
        ballSet.remove(new Ball(6));

        assertThatThrownBy(() -> new Lotto(ballSet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또는 중복된 숫자가 포함되면 에러가 발생한다")
    void validDuplicatedNumber() {
        ballSet.remove(new Ball(6));
        ballSet.add(new Ball(5));

        assertThatThrownBy(() -> new Lotto(ballSet))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
