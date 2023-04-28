package lotto.domain;

import lotto.service.LottoService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @ParameterizedTest(name = "{0}원 구입 => {1}회 로또 생성 ")
    @CsvSource(value = {"0:0", "1000:1", "15000:15", "21000:21"}, delimiter = ':')
    void 로또생성(int inputMoney, int expectedCount) {
        LottoService lottoService = new LottoService(inputMoney);
        lottoService.generate();
        assertThat(lottoService.getLottos().size()).isEqualTo(expectedCount);
    }
}