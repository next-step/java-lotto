package lotto.sevice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoRecord;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    LottoService lottoServie = new LottoService();
    
    @Test
    void lottoGameTest(){
        int[] lottoNumber = {1,2,3,4,5,6};
        Lotto lotto = new Lotto(lottoNumber);
        int[] winning = {1,2,3,4,5,6};
        int bonus = 2;
    
        LottoList lottoList = new LottoList(List.of(lotto));
        LottoRecord record = lottoServie.lottoGame(lottoList, winning, bonus);
        assertThat(record.getCountSix()).isEqualTo(1);
        assertThat(record.getProfit()).isEqualTo(200000);
    }

    @Test
    void IssueLottoTest(){
        int money = 14000;
        LottoList lottoList = lottoServie.issueLotto(money);
        assertThat(lottoList.getLottoList().size()).isEqualTo(14);
    }

    @Test
    void checkLottoTest(){
        int[] lottoNumber = {1,2,3,4,5,6};
        Lotto lotto = new Lotto(lottoNumber);
        int[] winning = {1,2,3,4,5,6};
        int bonus = 2;
    
        LottoList lottoList = new LottoList(List.of(lotto));
        LottoRecord record = lottoServie.checkLotto(lottoList, winning, bonus);
        assertThat(record.getCountSix()).isEqualTo(1);
    }

    @Test
    void check2ndLottoTest(){
        int[] lottoNumber = {1,2,3,4,5,6};
        Lotto lotto = new Lotto(lottoNumber);
        int[] winning = {1,2,3,4,5,9};
        int bonus = 6;
    
        LottoList lottoList = new LottoList(List.of(lotto));
        LottoRecord record = lottoServie.checkLotto(lottoList, winning, bonus);
        assertThat(record.getcountFiveAndBonus()).isEqualTo(1);
    }
}
