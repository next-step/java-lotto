package lotto.service;

import lotto.domain.*;
import lotto.dto.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoService = new LottoService();
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("로또 생성 테스트 : count 사이즈만큼 로또가 생성되는지 확인")
    @Test
    void issueLottos() {
        int count = 5;
        Lottos lottos = lottoService.issueLottos(count, lottoGenerator);

        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("로또 생성 테스트 : 당첨 번호와 몇개가 일치하는지 확인")
    @ParameterizedTest(name = "[{index}] {0} => {1}")
    @CsvSource(value = {
            "      1,2,3,4,5,6 | FIRST ",
            "      1,2,3,4,5,7 | SECOND ",
            "      1,2,3,4,7,8 | THIRD ",
            "      1,2,3,7,8,9 | FOURTH ",
            "     1,2,7,8,9,10 | FIFTH ",
            "    1,7,8,9,10,11 | SIXTH ",
            "   7,8,9,10,11,12 | NONE ",
    }, delimiter = '|')
    void calculateLottoRank(String input, LottoRank expectedRank) {
        Lotto lotto = Lotto.of(lottoGenerator); // 1,2,3,4,5,6
        Winning winning = Winning.of(input);

        LottoRank lottoRank = lottoService.calculateLottoRank(lotto, winning);

        assertThat(lottoRank).isEqualTo(expectedRank);
    }
}
