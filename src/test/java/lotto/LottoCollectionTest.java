package lotto;

import lotto.model.LottoCollection;
import lotto.model.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    private LottoCollection collection;
    private String[] numbers;

    @BeforeEach
    void setup() {
        List<Integer> lotto1 = List.of(3, 5, 10, 12, 16, 33);
        List<Integer> lotto2 = List.of(4, 6, 10, 11, 13, 18);
        List<Integer> lotto3 = List.of(7, 8, 14, 18, 19, 35);
        List<List<Integer>> lottos = List.of(lotto1, lotto2, lotto3);

        collection = new LottoCollection(lottos);
        numbers = new String[]{"1","2","3","4","5","6"};
    }

    @Test
    @DisplayName("구매한 로또개수 사이즈를 반환한다")
    void test() {
        assertThat(collection.checkWinningNumber(numbers).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨번호와 일치하는 숫자의 개수를 출력한다")
    void test2() {
        assertThat(collection.checkWinningNumber(numbers)).containsExactly(2,2,0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,1", "5,0", "6,0"})
    @DisplayName("일치하는 번호개수를 카운팅한다")
    void test3(int element, int expected) {
        Winning winning = new Winning(collection, new String[]{"3", "5", "10", "11", "13", "18"});
        assertThat(winning.getMatchingCount(integer -> integer == element)).isEqualTo(expected);
    }
}