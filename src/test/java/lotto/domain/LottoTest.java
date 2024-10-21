package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또를 생성한다.")
    void createLotto() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));

        Lotto lotto2 = new Lotto("6, 7, 8, 9, 10, 11");
        assertThat(lotto2).isEqualTo(new Lotto(6, 7, 8, 9, 10, 11));
    }

    @Test
    void 로또생성_숫자_6개검증() {
        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 6, 7);
        }).hasMessage("로또의 숫자는 6개이어야 합니다.");
    }

    @Test
    void 로또생성_숫자_중복검증() {
        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 1);
        }).hasMessage("로또는 중복된 숫자를 허용하지 않습니다.");
    }

    @Test
    void 로또와_당첨로또_일치개수_반환() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 5, 10, 22, 40);
        assertThat(userLotto.countMatchingNumbers(winningLotto)).isEqualTo(3);
    }
}
