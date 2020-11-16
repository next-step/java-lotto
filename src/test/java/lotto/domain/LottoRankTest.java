package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoRankTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }


    @DisplayName("matchCount에 따른 LottoRank 생성 테스트 : 실패 : matchCount가 잘못된 경우")
    @Test
    void of1() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoRank.of(9));
    }

    @DisplayName("matchCount에 따른 LottoRank 생성 테스트 : 성공 ")
    @ParameterizedTest
    @CsvSource(value = {
            " 0 | NONE ",
            " 1 | SIXTH ",
            " 2 | FIFTH ",
            " 3 | FOURTH ",
            " 4 | THIRD ",
            " 5 | SECOND ",
            " 6 | FIRST ",
    }, delimiter = '|')
    void of2(int matchCount, LottoRank exptectedLottoRank) {
        LottoRank lottoRank = LottoRank.of(matchCount);
        assertThat(lottoRank).isEqualTo(exptectedLottoRank);
    }
}
