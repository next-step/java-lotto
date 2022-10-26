package lotto.domain;

import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void size() {
        assertThat(new Lotto(new RandomNumberStrategy()).getLotto()).hasSize(6);
    }

    @Test
    void 범위() {
        Lotto lotto = new Lotto(new RandomNumberStrategy());
        for (Integer lottoNumber : lotto.getLotto()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(31);
        }
    }

    @Test
    void 로또_순서정렬() {
        List<Integer> testNumber = Arrays.asList(5,3,1,6,4,2);
        List<Integer> expectedList = Arrays.asList(1,2,3,4,5,6);
        assertThat(new Lotto(() -> testNumber).getLotto()).isEqualTo(expectedList);
    }

    @Test
    void 당첨번호_비교() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(() -> Arrays.asList(3,4,5,7,8,9));

        assertThat(lotto.matchCnt(winningLotto)).isEqualTo(3);
    }
}