package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LottoNumberTest {

    private LottoNumber lottoNumber;
    private LottoNumber winnerLottoNumber;

    @BeforeEach
    void setUp() {
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        winnerLottoNumber = new LottoNumber(winnerNumbers);
        lottoNumber = new LottoNumber(winnerNumbers);
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(lottoNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void createLottoNumberTest() {
        assertThat(new LottoNumber().getNumbers().size()).isEqualTo(6);
    }
}
