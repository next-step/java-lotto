package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;
import java.util.List;

import static lotto.model.Lotto.toLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    private LottoCollection collection;
    private List<String> numbers;

    @BeforeEach
    void setup() {
        Lotto lotto1 = toLottoNumber(List.of(3, 5, 10, 12, 16, 33));
        Lotto lotto2 = toLottoNumber(List.of(4, 6, 10, 11, 13, 18));
        Lotto lotto3 = toLottoNumber(List.of(7, 8, 14, 18, 19, 35));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        collection = new LottoCollection(lottos);
        numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("구매한 로또개수 사이즈를 반환한다")
    void test() {
        assertThat(collection.findWinner(numbers).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨번호와 일치하는 숫자의 개수를 출력한다")
    void test2() {
        assertThat(collection.findWinner(numbers)).containsExactly(2,2,0);
    }

    @ParameterizedTest
    @CsvSource(value = {"THREE,1", "FOUR,1", "FIVE,0", "SIX,0"})
    @DisplayName("일치하는 번호개수를 카운팅한다")
    void test3(Rank element, int expected) {
        WinningNumber winningNumber = new WinningNumber(collection, Arrays.asList("3", "5", "10", "11", "13", "18"));
        assertThat(winningNumber.getMatchingCount(element::event)).isEqualTo(expected);
    }
}