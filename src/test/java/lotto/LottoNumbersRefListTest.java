package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersRefListTest {

    @Test
    public void appendLottonNumber_로또리스트추가검증() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorStrategy_ref() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,2,3,4,5,6};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });

        LottoNumbersList_ref lottoNumbersListRef = new LottoNumbersList_ref();
        lottoNumbersListRef.appendLottoNumber(lottoNumbersRef);
        assertThat(lottoNumbersListRef.count()).isEqualTo(1);
    }

    @Test
    public void countWonNumbers_두개로또번호비교검증() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorStrategy_ref() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,2,3,4,5,6};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });

        LottoNumbersList_ref lottoNumbersListRef = new LottoNumbersList_ref();
        lottoNumbersListRef.appendLottoNumber(lottoNumbersRef);
        LastWonLottoNumber_ref lastWonLottoNumberRef = new LastWonLottoNumber_ref("1,2,3,4,5,6", "7");

        assertThat(lottoNumbersListRef.countMatchedNumbersList(lastWonLottoNumberRef).result().get(ResultScoreEnum_ref.FIRST)).isEqualTo(1);
    }

    @Test
    public void countWonNumbers_보너스번호비교검증() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorStrategy_ref() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,2,3,4,5,7};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        LottoNumbersList_ref lottoNumbersListRef = new LottoNumbersList_ref();
        lottoNumbersListRef.appendLottoNumber(lottoNumbersRef);
        LastWonLottoNumber_ref lastWonLottoNumberRef = new LastWonLottoNumber_ref("1,2,3,4,5,6", "7");

        assertThat(lottoNumbersListRef.countMatchedNumbersList(lastWonLottoNumberRef).result().get(ResultScoreEnum_ref.SECOND)).isEqualTo(1);
    }
}
