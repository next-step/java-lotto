package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    private WinningLotto winningLotto;
    private Lotto lotto;
    private LottoNumber bonusNumbers;
    @BeforeEach
    public void setUp(){
        List<LottoNumber> lottoNumber = new ArrayList<LottoNumber>();
        lottoNumber.add(new LottoNumber(1));
        lottoNumber.add(new LottoNumber(10));
        lottoNumber.add(new LottoNumber(20));
        lottoNumber.add(new LottoNumber(33));
        lottoNumber.add(new LottoNumber(40));
        lottoNumber.add(new LottoNumber(45));
        lotto = new Lotto(lottoNumber);
        bonusNumbers = new LottoNumber(1);

    }


    @DisplayName("보너스 번호 입력값이  지난주 당첨번호들중 중복되는 값이 있을경우")
    @Test
    void duplicateBonusNumber() {

        assertThatThrownBy(() ->{
            winningLotto = new WinningLotto(lotto, bonusNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}