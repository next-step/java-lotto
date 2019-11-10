package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private List<Integer> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        lotto = new Lotto(numbers);
    }

    @Test
    void lottoTest() {
        assertThat(numbers).hasSize(6);
    }

    @Test
    void sortTest() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLottoNumber()).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void containsLottoWinNumber() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContainsWinNumber(1)).isTrue();
        assertThat(lotto.isContainsWinNumber(7)).isFalse();
    }

    @Test
    void checkValueWhenHitWinNumber() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getHitCount(1)).isEqualTo(1);
        assertThat(lotto.getHitCount(6)).isEqualTo(1);
        assertThat(lotto.getHitCount(7)).isEqualTo(0);
    }

    @Test
    void getCountWhenHitWinNumber() {
        Lotto lotto = new Lotto(numbers);
        int[] testLottos = new int[] {1,2,3,7,8,9};
        assertThat(lotto.checkWinNumber(testLottos)).isEqualTo(3);
    }
}