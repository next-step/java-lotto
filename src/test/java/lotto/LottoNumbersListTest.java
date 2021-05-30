package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersListTest {

    @Test
    public void appendLottonNumber_로또리스트추가검증() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,2,3,4,5,6};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
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
                Integer[] lottoNumberArray = {1,2,3,4,5,6};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
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
                Integer[] lottoNumberArray = {1,2,3,4,5,7};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.appendLottoNumber(lottoNumbers);
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");

        assertThat(lottoNumbersList.countMatchedNumbersList(lastWonLottoNumber).result().get(ResultScoreEnum.SECOND)).isEqualTo(1);
    }
}
