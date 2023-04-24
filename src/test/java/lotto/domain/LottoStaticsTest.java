package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStaticsTest {

    private LottoStatics lottoStatics;

    @BeforeEach
    void init() {
        lottoStatics = new LottoStatics();
    }

    @Test
    void calculateMatchingCounts() throws Exception {
        //given
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoNumbers lottoNumbers
                = new LottoNumbers(lottoNumberList, new RandomNumberCreation());
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        Map<Integer, Integer> matchingCounts
                = lottoStatics.calculateMatchingCounts(lottoNumbers, winningNumber);

        //then
        assertThat(matchingCounts).containsKeys(3, 4, 5, 6).containsValues(0, 1, 2);
    }

    @Test
    void calculateGrossRateOfEarnings() throws Exception {
        //given
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoNumbers lottoNumbers
                = new LottoNumbers(lottoNumberList, new RandomNumberCreation());
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 20, 21, 22));
        lottoStatics.calculateMatchingCounts(lottoNumbers, winningNumber);

        //when
        double rate = lottoStatics.calculateGrossRateOfEarnings(3000);

        //then
        assertThat(rate).isEqualTo((double) 15000 / 3000);
    }
}
