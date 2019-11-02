package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LottoNumberTest {

    private LottoNumber lottoNumber;
    private List<Integer> winnerNumbers;

    @BeforeEach
    void setUp() {
        winnerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumber = new LottoNumber(winnerNumbers);
    }

    @Test
    void winLottoNumberTest() {
        assertThat(lottoNumber.matchNumberCount(winnerNumbers)).isEqualTo(6);
    }
}
