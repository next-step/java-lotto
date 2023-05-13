package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("Lotto_생성_테스트")
    public void Lotto_생성_테스트() {
        Lotto t_lotto = new Lotto();
        List<LottoNumber> numbers = t_lotto.getNumbers();
//        assertThat(numbers).containsAnyOf(1, 2, 3, 4, 5, 6);
    }

    static Stream<Arguments> generateRankData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, KLottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 10, KLottoRank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9), 6, KLottoRank.SECOND)
        );
    }

    @ParameterizedTest(name = "[{index}] {2}등 확인")
    @MethodSource("generateRankData")
    @DisplayName("Lotto_n등_테스트")
    public void Lotto_1등_테스트(List<Integer> winNumbers, int bonusNumber, KLottoRank expectedRank) {
        Lotto t_lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        KLottoRank rank = t_lotto.checkRank(new WinNumber(winNumbers, bonusNumber));
        assertThat(rank).isEqualTo(expectedRank);
    }
}
