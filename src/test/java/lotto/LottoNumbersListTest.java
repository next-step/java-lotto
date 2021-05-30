package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersListTest {

    @Test
    public void appendLottonNumber_로또리스트추가검증() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
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

        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.appendLottoNumber(lottoNumbers);
        assertThat(lottoNumbersList.count()).isEqualTo(1);
    }
    @Test
    public void countWonNumbers_두개로또번호비교검증() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
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

        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.appendLottoNumber(lottoNumbers);
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");

        assertThat(lottoNumbersList.countMatchedNumbersList(lastWonLottoNumber).result().get(ResultScoreEnum.FIRST)).isEqualTo(1);
    }

    @Test
    public void countWonNumbers_보너스번호비교검증() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
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
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.appendLottoNumber(lottoNumbers);
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");

        assertThat(lottoNumbersList.countMatchedNumbersList(lastWonLottoNumber).result().get(ResultScoreEnum.SECOND)).isEqualTo(1);
    }
}
