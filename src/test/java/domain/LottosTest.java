package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import service.RandomLottoGenerator;

class LottosTest {

    private RandomLottoGenerator randomLottoGenerator;

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        randomLottoGenerator = new RandomLottoGenerator();
        lottos = new Lottos();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("구입 갯수만큼 로또가 구매되어졌는지 확인하는 테스트")
    void 구입_갯수만큼_로또가_구매되어졌는지_확인하는_테스트(int purchaseCnt, int expectedCnt) {

        lottos.buyRandomLottos(randomLottoGenerator, purchaseCnt);

        assertThat(lottos.getLottoNumbers().size()).isEqualTo(expectedCnt);

    }

}