package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 결과에따른수익률() {
        int inputMoney = 1000;
        Money money = new Money(inputMoney);
        int quantity = money.purchaseQuantity();
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 9});
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 10})));
        LottoNumber bonusNumber = new LottoNumber(10);
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers, bonusNumber);
        double result = lottoResult.earningsRate(quantity);
        assertThat(result).isEqualTo(3000);
    }

    @Test
    public void 숫자3개가_일치한_로또갯수() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6})));
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 9});
        LottoNumber bonusNumber = new LottoNumber(10);
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers, bonusNumber);
        int count = lottoResult.matchLottoWithBonusCount(3, false);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 숫자5개와_보너스볼이_일치한_로또갯수() {
        List<Lotto> lottos = new ArrayList<>();
        LottoNumber bonusNumber = new LottoNumber(10);
        lottos.add(new Lotto(new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 10})));
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 9});
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers, bonusNumber);
        int count = lottoResult.matchLottoWithBonusCount(5, true);
        assertThat(count).isEqualTo(1);
    }

}