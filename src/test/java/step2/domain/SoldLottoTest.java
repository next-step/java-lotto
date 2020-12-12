package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SoldLottoTest {

    @Test
    @DisplayName(value = "count 만큼 로또를 생성하는지 테스트함.")
    void create() {
        SoldLotto soldLotto = new SoldLotto(10);
        assertThat(soldLotto.getSoldLotto().size()).isEqualTo(10);
    }

    @Test
    @DisplayName(value = "수동 로또와 자동로또를 같이 생성할 수 있는지 테스트")
    void createNotAutoLotto() {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> list2 = Arrays.asList(7,8,9,10,11,12);
        List<Integer> list3 = Arrays.asList(13,14,15,16,17,18);
        List<List<Integer>> notAutoLottos = Arrays.asList(list1, list2, list3);

        SoldLotto soldLotto = SoldLotto.of(0, notAutoLottos);

        assertThat(soldLotto.getSoldLotto().size()).isEqualTo(3);
        for (Lotto lotto : soldLotto.getSoldLotto()) {
            assertThat(lotto.isAuto()).isFalse();
        }
    }
}