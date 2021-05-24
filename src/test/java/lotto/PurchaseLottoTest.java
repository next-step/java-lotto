package lotto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLottoTest {

    @Test
    public void availablePurchaseLottoCount_구매가능매수확인() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        int lottoCount = purchaseLotto.availablePurchaseLottoCount(14000);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    public void purchaseAvailableLotto_구매로또개수생성검증() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        assertThat(purchaseLotto.purchaseAvailableLotto(14).count()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void lastWonLottoNumbers_지난당첨번호문자열파싱검증(int number) {
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6");
        assertThat(lastWonLottoNumber.contains(number)).isTrue();
    }

    @Test
    public void countWonNumbers_두개로또번호비교검증() {
        LottoNumber lottoNumber = new LottoNumber(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                List<Integer> lottoNumber = new ArrayList<Integer>();
                lottoNumber.add(1);
                lottoNumber.add(2);
                lottoNumber.add(3);
                lottoNumber.add(4);
                lottoNumber.add(5);
                lottoNumber.add(6);
                return lottoNumber;
            }
        });

        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6");

        PurchaseLotto purchaseLotto = new PurchaseLotto();
        assertThat(purchaseLotto.countWonNumbers(lottoNumber.getLottoNumbers(), lastWonLottoNumber.getLastWonLottoNumbers()).wonCount()).isEqualTo(6);
    }

}
