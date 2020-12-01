package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoMoneyTest {


    @Test
    @DisplayName(value = "WinningLottoMeney 생성 및 당첨 데이터 확인")
    void create() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(list);
        SoldLotto soldLotto = new SoldLotto(lotto);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);
        WinningLottoMoney winningLottoMoney = new WinningLottoMoney(soldLotto, winningLottoNumber);

        assertThat(winningLottoMoney).isNotNull();
        assertThat(winningLottoMoney.getWinningLottoMoney().get(LottoRank.ONE)).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "로또 결과를 기준으로 이익을 계산함.")
    void findBenefit() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(list);
        SoldLotto soldLotto = new SoldLotto(lotto);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);
        WinningLottoMoney winningLottoMoney = new WinningLottoMoney(soldLotto, winningLottoNumber);

        Fee fee = new Fee(1000);
        winningLottoMoney.findBenefitByFee(fee);
        assertThat(winningLottoMoney.findBenefitByFee(fee)).isEqualTo(new BigDecimal(2000000).setScale(2));

    }
}