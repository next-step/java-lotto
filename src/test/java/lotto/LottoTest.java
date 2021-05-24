package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

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

        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");

        Lotto lottoCompare = new Lotto();
        assertThat(lottoCompare.countWonNumbers(lottoNumber.getLottoNumbers(), lastWonLottoNumber).wonCount()).isEqualTo(6);
    }

    @Test
    public void countWonNumbers_보너스번호비교검증() {
        LottoNumber lottoNumber = new LottoNumber(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                List<Integer> lottoNumber = new ArrayList<Integer>();
                lottoNumber.add(1);
                lottoNumber.add(2);
                lottoNumber.add(3);
                lottoNumber.add(4);
                lottoNumber.add(5);
                lottoNumber.add(7);
                return lottoNumber;
            }
        });

        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");

        Lotto lottoCompare = new Lotto();
        assertThat(lottoCompare.countWonNumbers(lottoNumber.getLottoNumbers(), lastWonLottoNumber).bonusWonCount()).isEqualTo(1);
    }
}
