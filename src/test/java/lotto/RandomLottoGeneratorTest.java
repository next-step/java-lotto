package lotto;

import lotto.model.LottoNumber;
import lotto.model.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 로또 생성 테스트")
public class RandomLottoGeneratorTest {

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
    @DisplayName("RandomLottoGenerator로 생성된 로또 번호의 개수는 6개이다.")
    void lottoTest() {
        Set<LottoNumber> lottoNums = new RandomLottoGenerator().get();

        assertThat(lottoNums).hasSize(6);
    }
}
