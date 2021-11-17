package step2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void init() {
        lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void getMatchCount() {
        LottoNumbers matchSix = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers matchFive = new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNumbers matchFour = new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8));
        LottoNumbers matchThree = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertAll(
            () -> assertEquals(6, lottoNumbers.getMatchCount(matchSix)),
            () -> assertEquals(5, lottoNumbers.getMatchCount(matchFive)),
            () -> assertEquals(4, lottoNumbers.getMatchCount(matchFour)),
            () -> assertEquals(3, lottoNumbers.getMatchCount(matchThree))
        );
    }

}
