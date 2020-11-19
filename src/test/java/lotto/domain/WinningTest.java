package lotto.domain;

import lotto.dto.AnnounceWinning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Winning 생성 테스트")
    @Test
    void of() {
        AnnounceWinning announceWinning = AnnounceWinning.of("1,2,3,4,5,6");
        assertThat(Winning.of(announceWinning))
                .isEqualToComparingOnlyGivenFields(Winning.of(announceWinning));
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
        Winning winning = Winning.of(AnnounceWinning.of(input));

        Lottos lottos = new Lottos(Collections.singletonList(lotto));

        List<LottoRank> lottoRanks = winning.scratch(lottos);

        assertThat(lottoRanks).contains(containsLottoRank);
    }
}
