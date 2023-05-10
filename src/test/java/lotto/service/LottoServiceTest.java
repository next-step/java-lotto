package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoServiceTest {
    @ParameterizedTest(name = "{0}원 구입 => {1}회 로또 생성 ")
    @CsvSource(value = {"0:0", "1000:1", "15000:15", "21000:21"}, delimiter = ':')
    void 로또생성횟수(int inputMoney, int expectedCount) {
        LottoService lottoService = new LottoService();
        MyPurchase myPurchase = new MyPurchase(inputMoney);
        MyLottoGame myLottoGame = lottoService.buyAutoLottos(myPurchase);
        assertThat(myLottoGame.getLottos().size()).isEqualTo(expectedCount);
    }

    @Test
    void 당첨번호확인() {
        Numbers winNumbers = new Numbers(InputView.makeNumbers("1, 2, 3, 31, 32, 33"));
        Numbers matched3Numbers = new Numbers(InputView.makeNumbers("1, 2, 3, 41, 42, 43"));
        Numbers matched4Numbers = new Numbers(InputView.makeNumbers("1, 2, 3, 31, 44, 45"));

        List<Lotto> lottos = new ArrayList<>();
        //번호가 3개 일치하는 로또 개수 : 2개
        lottos.add(new Lotto(matched3Numbers));
        lottos.add(new Lotto(matched3Numbers));
        //번호가 4개 일치하는 로또 개수 : 3개
        lottos.add(new Lotto(matched4Numbers));
        lottos.add(new Lotto(matched4Numbers));
        lottos.add(new Lotto(matched4Numbers));

        MyPurchase myPurchase = new MyPurchase(5000);
        MyLottoGame myLottoGame = new MyLottoGame(new Lottos(lottos), myPurchase);

        WinLotto winLotto = new WinLotto(winNumbers);

        LottoService lottoService = new LottoService();

        lottoService.checkWin(myLottoGame, winLotto);

        assertAll(
                () -> assertThat(myLottoGame.countRank(Rank.FIFTH)).isEqualTo(2),
                () -> assertThat(myLottoGame.countRank(Rank.FOURTH)).isEqualTo(3),
                () -> assertThat(myLottoGame.countRank(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(myLottoGame.countRank(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(myLottoGame.countRank(Rank.FIRST)).isEqualTo(0)
        );
    }
}
