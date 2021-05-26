package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.view.LottoInputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "25000:25", "12500:12"}, delimiter = ':')
    void 입력된_구입금액_기준_로또_구매_기능_테스트(int value, int excepted) {
        LottoStore lottoStore = new LottoStore();
        BuyLottos buyLottos = lottoStore.buyAutoLottos(new LottoMachine(), new LottoPayment(value));
        assertThat(buyLottos.lottos().size()).isEqualTo(excepted);
    }

    @Test
    void 당첨_로또_객체_정상_생성_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public Lotto requestWinningLottoNumbers() {
                return new Lotto("1,2,3,4,5,6");
            }
        };
        LottoStore lottoStore = new LottoStore();
        Lotto winningLotto = lottoStore.createWinningLotto(lottoInputView);
        assertThat(winningLotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @Test
    void 로또_구매_금액_객체_정상_생성_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public LottoPayment requestInputPayment() {
                return new LottoPayment("14000");
            }
        };
        LottoStore lottoStore = new LottoStore();
        LottoPayment lottoPayment = lottoStore.createLottoPayment(lottoInputView);
        assertThat(lottoPayment).isEqualTo(new LottoPayment("14000"));
    }

    @Test
    void 보너스볼_생성_기능_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
                return new LottoNumber("7");
            }
        };

        LottoStore lottoStore = new LottoStore();
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        LottoNumber lottoNumber = lottoStore.createBonusBallLottoNumber(lottoInputView, winningLotto);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(7));
    }
}
