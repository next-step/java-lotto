package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrizeLottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp(){
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
    }

    @Test
    void matchBonusNumber() {
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,5,6", "7");
        assertThat(prizeLotto.matchBonusNumber(new Lotto("1,2,3,4,5,7"))).isTrue();
    }

    @Test
    public void 로또_비교(){
        PrizeLotto prizeLotto = new PrizeLotto("1,2,3,4,5,6", "7");
        assertThat(prizeLotto.getLotto()).isEqualTo(lottoNumbers);
    }
}