package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("N개의 로또를 가진 로또 그룹 생성이 가능하다")
    @Test
    void createLottoGruop() {
        Lottos lottos = Lottos.create(3);

        assertThat(lottos.count()).isEqualTo(3);
    }

    @DisplayName("로또 번호와 당첨번호와 비교하여 당첨번호와 같은 숫자의 갯수를 알 수 있다")
    @Test
    void countMatchingNumbers(){
        Lottos lottos = createLottos();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        /*
        첫번째 복권 당첨번호와 번호 같은 갯수 : 6
        두번째 복권 당첨번호와 번호 같은 갯수 : 0
        */
        assertThat(lottos.countMatchingNumbers(winningNumbers)).containsExactly(6, 0);
    }

    @DisplayName("로또들을 출력할 수 있다")
    @Test
    void showLottos(){
        Lottos lottos = createLottos();
        String printLotto = lottos.showLottos();

        assertThat(printLotto).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }

    private Lottos createLottos() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                        , new Lotto(List.of(7, 8, 9, 10, 11, 12))
                )
        );
        return lottos;
    }
}
