package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    void constructor() throws Exception {
        //given

        //when

        //then
        assertDoesNotThrow(() -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        });
    }
    
    @Test
    void countMatching() throws Exception {
        //given
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList, new RandomNumberCreation());
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        Map<LottoRank, Integer> result = winningNumber.countMatching(lottoNumbers);

        //then
        assertThat(result).containsKeys(LottoRank.FOURTH, LottoRank.FIRST).containsValues(1, 2);
    }
}
