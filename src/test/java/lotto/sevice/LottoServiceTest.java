package lotto.sevice;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoList;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {
    LottoService lottoServie = new LottoService();
    
    @Test
    void lottoGameTest(){
        int money = 14000;
        int[] winning = {1,2,3,4,5,6};
        LottoList lottoList = lottoServie.issueLotto(14000);
        lottoList.getLottoList().add(new Lotto(winning));
        LottoList winnerList = lottoServie.lottoGameTest(lottoList, winning);
        assertThat(lottoList.getLottoList().size()).isEqualTo(1);
    }

    @Test
    void IssueLottoTest(){
        int money = 14000;
        LottoList lottoList = lottoServie.issueLotto(14000);
        assertThat(lottoList.getLottoList().size()).isEqualTo(14);
    }

    @Test
    void checkLottoTest(){
        int money = 14000;
        int[] winning = {1,2,3,4,5,6};
        LottoList lottoList = lottoServie.issueLotto(14000);
        lottoList.getLottoList().add(new Lotto(winning));
        LottoList winnerList = lottoServie.checkLotto(lottoList, winning);
        assertThat(lottoList.getLottoList().size()).isEqualTo(1);
    }
}
