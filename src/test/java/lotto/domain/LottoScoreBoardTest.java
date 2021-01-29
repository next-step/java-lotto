package lotto.domain;

import lotto.dto.LottoGameProfitDTO;
import lotto.dto.ScoreBoardData;
import lotto.dto.ScoreData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoScoreBoardTest {
    private static Stream<Arguments> providerCalculateProfitParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(LottoScore.THIRD), 1_500),
            Arguments.of(Arrays.asList(LottoScore.NOTHING, LottoScore.THIRD), 750),
            Arguments.of(Arrays.asList(LottoScore.NOTHING, LottoScore.NOTHING, LottoScore.THIRD), 500)
        );
    }

    @DisplayName("스코어들의 정보에 따른 결과 데이터를 잘 생성하는지 확인")
    @ParameterizedTest
    @MethodSource("providerCalculateProfitParams")
    void calculateProfit(List<LottoScore> scores, double profit) {
        LottoScoreBoard scoreBoard = new LottoScoreBoard(scores);

        assertEquals(
            new ScoreBoardData(
                new ArrayList<ScoreData>() {{
                    add(new ScoreData(LottoScore.FIFTH, 0));
                    add(new ScoreData(LottoScore.FOURTH, 0));
                    add(new ScoreData(LottoScore.THIRD, 1));
                    add(new ScoreData(LottoScore.SECOND, 0));
                    add(new ScoreData(LottoScore.FIRST, 0));
                }},
                profit
            ),
            scoreBoard.getScoreBoardData()
        );
    }
}