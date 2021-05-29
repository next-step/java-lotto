package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.view.LottoInputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "25000:25", "12500:12"}, delimiter = ':')
    void 입력된_구입금액_기준_로또_구매_기능_테스트(int value, int excepted) {
        LottoStore lottoStore = new LottoStore(new LottoInputView(), new LottoMachine());
        BuyLottos buyLottos = lottoStore.buyAutoLottos(LottoPayment.create(value));
        assertThat(buyLottos.lottos().size()).isEqualTo(excepted);
    }

    @Test
    void 당첨_로또_객체_정상_생성_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public Lotto requestWinningLottoNumbers() {

                return Lotto.create(lottoNumbers);
            }
        };
        LottoStore lottoStore = new LottoStore(lottoInputView, new LottoMachine());
        Lotto winningLotto = lottoStore.createWinningLotto();
        assertThat(winningLotto).isEqualTo(Lotto.create(lottoNumbers));
    }

    @Test
    void 로또_구매_금액_객체_정상_생성_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public LottoPayment requestInputPayment() {
                return LottoPayment.create(14000);
            }
        };
        LottoStore lottoStore = new LottoStore(lottoInputView, new LottoMachine());
        LottoPayment lottoPayment = lottoStore.createLottoPayment();
        assertThat(lottoPayment).isEqualTo(LottoPayment.create(14000));
    }

    @Test
    void 보너스볼_생성_기능_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
                return LottoNumber.create(7);
            }
        };
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        LottoStore lottoStore = new LottoStore(lottoInputView, new LottoMachine());
        Lotto winningLotto = Lotto.create(lottoNumbers);
        LottoNumber lottoNumber = lottoStore.createBonusBallLottoNumber(winningLotto);
        assertThat(lottoNumber).isEqualTo(LottoNumber.create(7));
    }

    @Test
    void 수동으로_구해할_로또_수_입력_기능_테스트() {
        LottoInputView lottoInputView = new LottoInputView() {
            @Override
            public PurchaseQuantity requestManualLottoPurchaseQuantity(LottoPayment lottoPayment) {
                return PurchaseQuantity.create(3);
            }
        };
        LottoPayment lottoPayment = LottoPayment.create(14000);
        LottoStore lottoStore = new LottoStore(lottoInputView, new LottoMachine());
        PurchaseQuantity purchaseQuantity = lottoStore.createManualLottoPurchaseQuantity(lottoPayment);
        assertThat(purchaseQuantity).isEqualTo(PurchaseQuantity.create(3));
    }

    @Test
    void 수동_구매_수량에따라_구매_수동_로또_생성_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        LottoInputView lottoInputView = new LottoInputView(){
            @Override
            public List<List<LottoNumber>> requestManualLottoNumbers(PurchaseQuantity purchaseQuantity) {
                return Arrays.asList(lottoNumbers);
            }
        };
        LottoStore lottoStore = new LottoStore(lottoInputView, new LottoMachine());
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.create(1);
        List<Lotto> manualLottos = lottoStore.createManualLottos(purchaseQuantity);
        assertThat(purchaseQuantity.isSame(manualLottos.size())).isTrue();
        assertThat(manualLottos).isEqualTo(Arrays.asList(Lotto.create(lottoNumbers)));
    }
}
