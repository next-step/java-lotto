package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [기능분석]
 * 로또는 랜덤번호로 로또를 생성할 수 있다.
 * 로또는 수동번호로 로또를 생성할 수 있다.
 * 로또는 당첨로또와 비교하여 몇개 맞추었는지 계산할 수 있다.
 */
public class LottoTest {

    @Test
    @DisplayName("로또는 랜덤번호로 자신을 생성할 수 있다.")
    void 로또생성_랜덤번호() {
        new Lotto();
    }

    @Test
    @DisplayName("로또는 수동번호로 자신을 생성할 수 있다.")
    void 로또생성_수동번호() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(6, 5, 4, 3, 2, 1));

        lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(6,5,4,3,2,1))));
    }

    @Test
    @DisplayName("당첨로또와 비교하여 몇개 맞추었는지 계산할 수 있다.")
    void 로또비교() {
        Lotto target = new Lotto(1, 2, 3, 4, 5, 6);

        Lotto firstPlace = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto secondPlace = new Lotto(2, 3, 4, 5, 6, 7);
        Lotto thirdPlace = new Lotto(3, 4, 5, 6, 7, 8);
        Lotto fourthPlace = new Lotto(4, 5, 6, 7, 8, 9);
        Lotto fifthPlace = new Lotto(5, 6, 7, 8, 9, 10);
        Lotto sixthplace = new Lotto(6, 7, 8, 9, 10, 11);
        Lotto lose = new Lotto(7, 8, 9, 10, 11, 12);

        assertThat(firstPlace.result(target)).isEqualTo(Prize.FIRST);
        assertThat(secondPlace.result(target)).isEqualTo(Prize.SECOND);
        assertThat(thirdPlace.result(target)).isEqualTo(Prize.THIRD);
        assertThat(fourthPlace.result(target)).isEqualTo(Prize.FOURTH);
        assertThat(fifthPlace.result(target)).isEqualTo(Prize.FIFTH);
        assertThat(sixthplace.result(target)).isEqualTo(Prize.SIXTH);
        assertThat(lose.result(target)).isEqualTo(Prize.LOSE);
    }
}
