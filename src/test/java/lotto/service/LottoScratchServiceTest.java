package lotto.service;

import lotto.domain.*;
import lotto.dto.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoScratchServiceTest {

    private LottoScratchService lottoScratchService;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoScratchService = new LottoScratchService();
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("로또 긁기 테스트 : 당첨 번호와 몇개가 일치하는지 확인")
    @ParameterizedTest(name = "[{index}] {0} => 일치 갯수 {1}")
    @CsvSource(value = {
            "      1,2,3,4,5,6 | 6 ",
            "      1,2,3,4,5,7 | 5 ",
            "      1,2,3,4,7,8 | 4 ",
            "      1,2,3,7,8,9 | 3 ",
            "     1,2,7,8,9,10 | 2 ",
            "    1,7,8,9,10,11 | 1 ",
            "   7,8,9,10,11,12 | 0 ",
    }, delimiter = '|')
    void calculateMathCount(String input, int expectedMatchCount) {
        Lotto lotto = Lotto.of(lottoGenerator); // 1,2,3,4,5,6
        Winning winning = Winning.of(input);

        int matchCount = lottoScratchService.calculateMatchCount(lotto, winning);

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @DisplayName("로또 긁기 테스트 : 당첨 번호에 따른 LottoRank 확인")
    @ParameterizedTest(name = "[{index}] {0} =>  {1}")
    @CsvSource(value = {
            "      1,2,3,4,5,6 | FIRST ",
            "      1,2,3,4,5,7 | SECOND ",
            "      1,2,3,4,7,8 | THIRD ",
            "      1,2,3,7,8,9 | FOURTH ",
            "     1,2,7,8,9,10 | NONE ",
            "    1,7,8,9,10,11 | NONE ",
            "   7,8,9,10,11,12 | NONE ",
    }, delimiter = '|')
    void scratch1(String input, LottoRank containsLottoRank) {
        Lotto lotto = Lotto.of(lottoGenerator); // 1,2,3,4,5,6
        Winning winning = Winning.of(input);

        Lottos lottos = new Lottos(Collections.singletonList(lotto));

        List<LottoRank> lottoRanks = lottoScratchService.scratch(lottos, winning);

        assertThat(lottoRanks).contains(containsLottoRank);
    }
}
