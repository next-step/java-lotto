package lotto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private List<Integer> testLottoNumber;
    private List<Integer> lottoNumberRange;

    @BeforeEach
    public void setUp() {
        testLottoNumber = new ArrayList<Integer>();
        lottoNumberRange = new ArrayList<Integer>();
        for(int i=1; i<46; i++) {
            lottoNumberRange.add(i);
        }
    }

    @Test
    public void generateLottoNumber_validate() {
        LottoNumberGenerator lottoNumber = new LottoNumberGenerator();
        testLottoNumber = lottoNumber.generateLottoNumber();

        assertThat(lottoNumberRange.contains(testLottoNumber.get(0))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(1))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(2))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(3))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(4))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(5))).isTrue();
    }

    @Test
    public void availablePurchaseLottoCount_validate() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        int lottoCount = purchaseLotto.availablePurchaseLottoCount(14000);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    public void purchasedLotto_count_validate() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLotto.purchaseLotto(14);
        assertThat(purchaseLotto.getLottoNumberList().count()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void setLastWonLottoNumbers_init(int number) {
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6");
        assertThat(lastWonLottoNumber.contains(number)).isTrue();
    }

    @Test
    public void CheckWinOrLose_validate() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        //purchaseLotto.
        //purchaseLotto.setLastWonLottoNumbers("1,2,3,4,5,6");
    }



}
