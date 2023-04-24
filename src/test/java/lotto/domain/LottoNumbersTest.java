package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void init() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoNumberList.add(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoNumbers = new LottoNumbers(lottoNumberList, new RandomNumberCreation());
    }

    @Test
    void constructor() throws Exception {
        //given

        //when

        //then
        assertDoesNotThrow(() -> {
            new LottoNumbers(3, new RandomNumberCreation());
        });
    }

    @Test
    void calculateSameNumberCount() throws Exception {
        //given
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        Map<Integer, Integer> sameNumberCounts
                = lottoNumbers.calculateSameNumberCounts(winningNumber);

        //then
        assertThat(sameNumberCounts).containsKeys(3, 6).containsValues(1, 2);
    }
}
