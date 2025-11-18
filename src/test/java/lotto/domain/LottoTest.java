package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

//- [ ] 로또 번호는 총 6개이다
//- [ ] 로또 번호는 중복되지 않아야 한다
//    - [ ] 로또 번호 중복 시 IllegalArgumentException을 발생시킨다

public class LottoTest {

    @Test
    void 로또_번호_6개로_생성() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void 로또_번호_6개가_아니면_예외발생() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 총 6개여야 합니다.");
    }

    @Test
    void 로또_번호가_중복되면_예외발생() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또_번호_범위가_1에서_45가_아니면_예외발생() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 한다");
    }

    @Test
    void 로또_번호가_오름차순으로_정렬되어_저장됨() {
        Lotto lotto = new Lotto(6, 5, 4, 3, 2, 1);

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호와_일치하는_개수_확인() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winNumbers = new Lotto(1, 2, 3, 7, 8, 9);

        int matchCountNumber = lotto.countMatchNumber(winNumbers);

        assertThat(matchCountNumber).isEqualTo(3);
    }

}
