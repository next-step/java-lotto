package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

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
        LottoNumberGenerator lottoNumber = new LottoNumberGenerator();
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
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,3,5,7,9,11};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        assertThat(lottoNumbers.contains(1)).isTrue();
    }

    @Test
    public void countMatchedNumbers_로또번호_맞춘_갯수_검증() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                Integer[] lottoNumberArray = {1,3,5,7,9,11};
                List<Integer> lottoNumber = Arrays.asList(lottoNumberArray);
                return lottoNumber;
            }
        });
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,3,5,6,7,8","10");
        assertThat(lottoNumbers.countMatchedNumbers(lastWonLottoNumber).getResultScore()).isEqualTo(ResultScoreEnum.FOURTH);
    }
}
