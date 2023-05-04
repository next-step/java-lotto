package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class KLottoRankTest {
    static Stream<Arguments> generateRankData() {
        return Stream.of(Arguments.of(6, false, KLottoRank.FIRST),
                Arguments.of(5, true, KLottoRank.SECOND),
                Arguments.of(5, false, KLottoRank.THIRD),
                Arguments.of(4, false, KLottoRank.FOURTH),
                Arguments.of(3, false, KLottoRank.FIFTH)
        );
    }

    @ParameterizedTest(name = "[{index}] {2}등 확인")
    @MethodSource("generateRankData")
    @DisplayName("Rank Enum 확인")
    public void Enum_RANK_테스트(int matchCount, boolean bonus, KLottoRank result){
        assertThat(KLottoRank.find(matchCount, bonus)).isEqualTo(result);
    }
}