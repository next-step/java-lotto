package lotto.domain;

import lotto.dto.LottoGameProfitDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoScoreBoardTest {
    private static Stream<Arguments> providerCalculateProfitParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(LottoScore.FIRST), 2_000_000),
            Arguments.of(Arrays.asList(LottoScore.NOTHING, LottoScore.FIFTH), 2.5),
            Arguments.of(Arrays.asList(LottoScore.NOTHING, LottoScore.NOTHING, LottoScore.THIRD), 500),
            Arguments.of(Arrays.asList(LottoScore.NOTHING, LottoScore.NOTHING, LottoScore.NOTHING, LottoScore.NOTHING), 0)
        );
    }

    @DisplayName("스코어들의 정보에 따른 수익률을 잘 계산하는지 확인")
    @ParameterizedTest
    @MethodSource("providerCalculateProfitParams")
    void calculateProfit(List<LottoScore> scores, double profit) {
        LottoScoreBoard scoreBoard = new LottoScoreBoard(scores);

        assertEquals(
            scoreBoard.calculateProfit(),
            new LottoGameProfitDTO(profit)
        );
    }
}