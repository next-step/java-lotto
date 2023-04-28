import mission.lotto.KLottoRank;
import mission.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("Lotto_생성_테스트")
    public void Lotto_생성_테스트() {

        Lotto t_lotto = new Lotto(new TestLottoGenerator());

        List<Integer> numbers = t_lotto.getNumbers();
        String name = t_lotto.getName();

        assertThat(name).isEqualTo("Test-mission.lotto.Lotto");
        assertThat(numbers).containsAnyOf(1, 2, 3, 4, 5, 6);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, KLottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 3, KLottoRank.FOURTH)
        );
    }

    @ParameterizedTest(name = "[{index}] {0} 로또 매칭 갯수")
    @MethodSource("generateData")
    @DisplayName("Lotto_매칭갯수_테스트")
    public void Lotto_매칭갯수_테스트(List<Integer> winNumbers, int expected) {
        Lotto t_lotto = new Lotto(new TestLottoGenerator());
        int result = t_lotto.matchCount(winNumbers);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] {2}등 확인")
    @MethodSource("generateData")
    @DisplayName("Lotto_n등_테스트")
    public void Lotto_1등_테스트(List<Integer> winNumbers, int count, KLottoRank expectedRank) {
        Lotto t_lotto = new Lotto(new TestLottoGenerator());
        int result = t_lotto.matchCount(winNumbers);
        KLottoRank rank = t_lotto.checkRank(result);
        assertThat(rank).isEqualTo(expectedRank);
    }
}
