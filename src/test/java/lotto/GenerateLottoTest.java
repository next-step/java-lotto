package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성 테스트")
public class GenerateLottoTest {

    @Test
    @DisplayName("Collections.shuffle 을 이용해 1부터 45사이의 값을 넣은 리스트를 섞어 값이 잘 나오는지 테스트 ")
    void shuffleTest() {
        // given
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }

        // when
        Collections.shuffle(nums);

        // then
        while (!nums.isEmpty()) {
            assertThat(nums.remove(0)).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("생성된 로또 번호의 개수는 6개이다.")
    void lottosTest() {
        Lottos lottos = GenerateLotto.get();

        List<Integer> lottoNums = lottos.get();

        assertThat(lottoNums).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호 6개 모두 1-45사이의 값을 가지고 있다. ")
    void getTest() {
        // given
        Lottos lottos = GenerateLotto.get();

        // when
        List<Integer> lottoNums = lottos.get();

        // then
        for (int i = 0; i < lottoNums.size(); i++) {
            assertThat(lottoNums.get(i)).isBetween(1, 45);
        }
    }
}
