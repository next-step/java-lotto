package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또 번호 개수 테스트")
    public void lotteNumbersSizeTest() {
        Lotto lotto = new Lotto();
        int[] numbers = lotto.getNumbers();

        assertThat(numbers.length).isEqualTo(Config.LOTTE_NUMBER_COUNT);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    public void lotteNumbersRangeTest() {
        Lotto lotto = new Lotto();
        int[] numbers = lotto.getNumbers();

        for (int number : numbers) {
            assertThat(number).isBetween(Config.LOTTE_NUMBER_RANGE_TO_MIN, Config.LOTTE_NUMBER_RANGE_TO_MAX);
        }
    }

    @Test
    @DisplayName("로또 번호 일치 개수 테스트")
    public void lotteMatchCountTest() {
        Lotto lotto = new Lotto();
        int[] numbers = lotto.getNumbers();

        List<Integer> customCollectNumberList = new ArrayList<>();
        for(int index = 0; index < Config.LOTTE_NUMBER_COUNT; index++){
            assertThat(lotto.getMatchCount(customCollectNumberList)).isEqualTo(index);
            customCollectNumberList.add(numbers[index]);
        }
    }
}