package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
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
        LottoService lottoService = new LottoService();
        MyLottos myLottos = lottoService.autoGenerate(inputMoney);
        assertThat(myLottos.count()).isEqualTo(expectedCount);
    }

    @Test
    void 당첨번호확인() {
        List<MyLotto> lottos = new ArrayList<>();
        //번호 3개 일치
        lottos.add(new MyLotto(getNumbersForTest("3, 6, 9, 31, 37, 40")));
        lottos.add(new MyLotto(getNumbersForTest("3, 6, 9, 31, 37, 40")));
        //번호 4개 일치
        lottos.add(new MyLotto(getNumbersForTest("3, 6, 9, 30, 37, 40")));
        lottos.add(new MyLotto(getNumbersForTest("3, 6, 9, 30, 37, 40")));
        lottos.add(new MyLotto(getNumbersForTest("3, 6, 9, 30, 37, 40")));

        Purchase purchase = new Purchase(5000);

        MyLottos myLottos = new MyLottos(lottos, purchase);

        LottoService lottoService = new LottoService();

        WinLotto winLotto = new WinLotto(getNumbersForTest("3, 6, 9, 30, 36, 39"));

        lottoService.checkWin(myLottos,winLotto);

        assertThat(myLottos.result().getMatched3NumbersCount()).isEqualTo(2);
        assertThat(myLottos.result().getMatched4NumbersCount()).isEqualTo(3);
        assertThat(myLottos.result().getMatched5NumbersCount()).isEqualTo(0);
        assertThat(myLottos.result().getMatched6NumbersCount()).isEqualTo(0);
    }

    private static Numbers getNumbersForTest(String input) {
        List<Integer> inputNumbers = InputView.makeNumbers(input);
        Numbers numbers = new Numbers(inputNumbers);
        return numbers;
    }
}
