package lotto.service;

import lotto.domain.MyLotto;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

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
    void 당첨번호확인() {
        List<MyLotto> myLottos = new ArrayList<>();
        //3개 당첨
        myLottos.add(MyLotto.manual("3, 6, 9, 31, 37, 40"));
        myLottos.add(MyLotto.manual("3, 6, 9, 31, 37, 40"));
        //4개 당첨
        myLottos.add(MyLotto.manual("3, 6, 9, 30, 37, 40"));
        myLottos.add(MyLotto.manual("3, 6, 9, 30, 37, 40"));
        myLottos.add(MyLotto.manual("3, 6, 9, 30, 37, 40"));

        LottoService lottoService = new LottoService(5000, myLottos);

        WinLotto winLotto = new WinLotto("3, 6, 9, 30, 36, 39");

        lottoService.checkMyLottosWin(winLotto);

        assertThat(lottoService.result().getResult3matched()).isEqualTo(2);
        assertThat(lottoService.result().getResult4matched()).isEqualTo(3);
        assertThat(lottoService.result().getResult5matched()).isEqualTo(0);
        assertThat(lottoService.result().getResult6matched()).isEqualTo(0);
    }
}
