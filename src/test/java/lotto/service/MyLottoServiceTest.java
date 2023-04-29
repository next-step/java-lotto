package lotto.service;

import lotto.domain.MyLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoServiceTest {
    @ParameterizedTest(name = "{0}원 구입 => {1}회 로또 생성 ")
    @CsvSource(value = {"0:0", "1000:1", "15000:15", "21000:21"}, delimiter = ':')
    void 로또생성횟수(int inputMoney, int expectedCount) {
        LottoService lottoService = new LottoService(inputMoney);
        lottoService.autoGenerate();
        assertThat(lottoService.lottos().size()).isEqualTo(expectedCount);
    }

    @Test
    void 당첨확인() {
        MyLotto myLotto = MyLotto.manual("7, 14, 21, 22, 44, 45");
    }
}