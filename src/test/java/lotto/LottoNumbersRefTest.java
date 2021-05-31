package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersRefTest {

    private List<Integer> testLottoNumber;
    private List<Integer> lottoNumberRange;

    @BeforeEach
    public void setUp() {
        testLottoNumber = new ArrayList<Integer>();
        lottoNumberRange = new ArrayList<Integer>();
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(i);
        }
    }

    @Test
    public void generateLottoNumber_로또번호1_45범위내생성확인() {
        LottoNumberGeneratorRef lottoNumber = new LottoNumberGeneratorRef();
        testLottoNumber = lottoNumber.generateLottoNumber();

        assertThat(lottoNumberRange.contains(testLottoNumber.get(0))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(1))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(2))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(3))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(4))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(5))).isTrue();
    }

    @Test
    public void makeLottoNumber_로또번호생성확인() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorStrategy_ref() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,3,5,7,9,11};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        assertThat(lottoNumbersRef.contains(1)).isTrue();
    }

    @Test
    public void countMatchedNumbers_로또번호_맞춘_갯수_검증() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorStrategy_ref() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,3,5,7,9,11};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        LastWonLottoNumber_ref lastWonLottoNumberRef = new LastWonLottoNumber_ref("1,3,5,6,7,8","10");
        assertThat(lottoNumbersRef.countMatchedNumbers(lastWonLottoNumberRef).getResultScore()).isEqualTo(ResultScoreEnum.FOURTH);
    }

    @Test
    public void purchase_수동구매_로또개수제외하고_자동번호생성검증() {

    }

    @Test
    public void purchase_수동구매_로또번호_생성검증() {

    }
}
