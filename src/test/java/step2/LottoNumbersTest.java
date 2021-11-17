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
        LottoNumbers firstRank = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers secondRank = new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNumbers thirdRank = new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8));
        LottoNumbers fourthRank = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertAll(
            () -> assertEquals(6, lottoNumbers.getMatchCount(firstRank)),
            () -> assertEquals(5, lottoNumbers.getMatchCount(secondRank)),
            () -> assertEquals(4, lottoNumbers.getMatchCount(thirdRank)),
            () -> assertEquals(3, lottoNumbers.getMatchCount(fourthRank))
        );
    }

}
