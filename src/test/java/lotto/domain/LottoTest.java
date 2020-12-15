package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void create() {
        List<Integer> numbers = Arrays.asList(2, 43, 53, 11, 41, 42);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(2, 43, 53, 11, 41, 42)));
    }

    @Test
    @DisplayName("당첨 로또 확인하기 : 3개 일치")
    void match_3_nums_test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Lotto lotto = new Lotto(numbers);

        long result = lotto.matchNumberCnt(new Lotto(Arrays.asList(3, 4, 5, 6, 7)));

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 로또 확인하기 : 0개 일치")
    void match_0_nums_test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Lotto lotto = new Lotto(numbers);

        long result = lotto.matchNumberCnt(new Lotto(Arrays.asList(9, 10, 11, 6, 7)));

        assertThat(result).isZero();
    }
}
