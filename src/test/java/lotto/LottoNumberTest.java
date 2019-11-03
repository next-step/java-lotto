package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LottoNumberTest {

    private LottoNumber firstPlaceNumber;
    private LottoNumber secondPlaceNumber;
    private LottoNumber thirdPlaceNumber;
    private LottoNumber fourthPlaceNumber;
    private LottoNumber notMatchNumber;
    private LottoNumber winnerLottoNumber;

    @BeforeEach
    void setUp() {
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        winnerLottoNumber = new LottoNumber(winnerNumbers);
        firstPlaceNumber = new LottoNumber(winnerNumbers);
        secondPlaceNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 40));
        thirdPlaceNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 20, 40));
        fourthPlaceNumber = new LottoNumber(Arrays.asList(1, 2, 3, 12, 20, 40));
        notMatchNumber = new LottoNumber(Arrays.asList(1, 2, 9, 12, 20, 40));
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(firstPlaceNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.FIRST);
        assertThat(secondPlaceNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.SECOND);
        assertThat(thirdPlaceNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.THIRD);
        assertThat(fourthPlaceNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.FOURTH);
        assertThat(notMatchNumber.getRank(winnerLottoNumber)).isEqualTo(LottoRank.NOT_MATCH);
    }

    @Test
    void createLottoNumberTest() {
        assertThat(new LottoNumber().getNumbers().size()).isEqualTo(6);
    }

    @Test
    void invalidNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).withMessage(LottoNumber.GRATER_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5));
        }).withMessage(LottoNumber.LESS_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).withMessage(LottoNumber.DUPLICATED_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(-1, 2, 3, 4, 5, 6));
        }).withMessage(LottoNumber.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).withMessage(LottoNumber.INVALID_RANGE_NUMBER_ERROR);
    }
}
