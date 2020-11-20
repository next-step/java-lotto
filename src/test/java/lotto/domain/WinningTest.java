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
        AnnounceWinning announceWinning = AnnounceWinning.of("1,2,3,4,5,6", "7");
        assertThat(Winning.of(announceWinning))
                .isEqualToComparingOnlyGivenFields(Winning.of(announceWinning));
    }

    @DisplayName("로또 긁기 테스트 : 당첨 번호에 따른 LottoRank 확인")
    @ParameterizedTest(name = "[{index}] {0} (bonus:{1}) =>  {2}")
    @CsvSource(value = {
            "      1,2,3,4,5,6 | 7 | FIRST ",
            "      1,2,3,4,5,7 | 6 | SECOND ",
            "      1,2,3,4,5,7 | 8 | THIRD ",
            "      1,2,3,4,7,8 | 5 | FOURTH ",
            "      1,2,3,4,7,8 | 9 | FOURTH ",
            "      1,2,3,7,8,9 | 5 | FIFTH ",
            "      1,2,3,7,8,9 | 10 | FIFTH ",
            "     1,2,7,8,9,10 |  5 | NONE ",
            "     1,2,7,8,9,10 | 11 | NONE ",
            "    1,7,8,9,10,11 |  5 | NONE ",
            "    1,7,8,9,10,11 | 12 | NONE ",
            "   7,8,9,10,11,12 |  5 | NONE ",
            "   7,8,9,10,11,12 | 13 | NONE ",
    }, delimiter = '|')
    void scratch1(String input, String bonus, LottoRank containsLottoRank) {
        Lotto lotto = Lotto.of(lottoGenerator); // 1,2,3,4,5,6
        Winning winning = Winning.of(AnnounceWinning.of(input, bonus));

        Lottos lottos = new Lottos(Collections.singletonList(lotto));

        List<LottoRank> lottoRanks = winning.scratch(lottos);

        assertThat(lottoRanks).contains(containsLottoRank);
    }
}
