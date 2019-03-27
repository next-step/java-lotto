package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 결과에따른수익률() {
        int inputMoney = 14000;
        Money money = new Money(inputMoney);
        int quantity = money.purchaseQuantity();
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 9});
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6})));
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers);
        double result = lottoResult.earningsRate(quantity);
        assertThat(result).isEqualTo(0.35);
    }

    @Test
    public void 숫자3개가_일치한_로또갯수() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6})));
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 7, 8, 9});
        LottoResult lottoResult = new LottoResult(lottos, luckyNumbers);
        int count = lottoResult.matchLottoCount(3);
        assertThat(count).isEqualTo(1);
    }
}