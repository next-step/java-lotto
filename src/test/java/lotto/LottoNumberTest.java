package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    private List<Integer> testLottoNumber;
    private List<Integer> lottoNumberRange;

    @BeforeEach
    public void setUp() {
        testLottoNumber = new ArrayList<Integer>();
        lottoNumberRange = new ArrayList<Integer>();
        for(int i=1; i<46; i++) {
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
        LottoNumber lottoNumber = new LottoNumber(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                List<Integer> lottoNumberList = new ArrayList<Integer>();
                lottoNumberList.add(1);
                lottoNumberList.add(3);
                lottoNumberList.add(5);
                lottoNumberList.add(7);
                lottoNumberList.add(9);
                lottoNumberList.add(11);
                return lottoNumberList;
            }
        });

        assertThat(lottoNumber.getLottoNumbers().contains(1)).isTrue();
    }

}
