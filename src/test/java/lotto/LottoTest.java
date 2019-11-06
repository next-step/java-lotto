package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LottoTest {

    private Lotto firstPlaceNumber;
    private Lotto secondPlaceNumber;
    private Lotto thirdPlaceNumber;
    private Lotto fourthPlaceNumber;
    private Lotto notMatchNumber;
    private Lotto winnerLotto;

    @BeforeEach
    void setUp() {
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        winnerLotto = new Lotto(new LottoNumbers(winnerNumbers,7));
        firstPlaceNumber = new Lotto(new LottoNumbers(winnerNumbers,7));
        secondPlaceNumber = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 40), 7));
        thirdPlaceNumber = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 20, 40), 8));
        fourthPlaceNumber = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 12, 20, 40), 8));
        notMatchNumber = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 9, 12, 20, 40), 8));
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(firstPlaceNumber.getRank(winnerLotto.getLottoNumbers())).isEqualTo(LottoRank.FIRST);
        assertThat(secondPlaceNumber.getRank(winnerLotto.getLottoNumbers())).isEqualTo(LottoRank.SECOND);
        assertThat(thirdPlaceNumber.getRank(winnerLotto.getLottoNumbers())).isEqualTo(LottoRank.THIRD);
        assertThat(fourthPlaceNumber.getRank(winnerLotto.getLottoNumbers())).isEqualTo(LottoRank.FOURTH);
        assertThat(notMatchNumber.getRank(winnerLotto.getLottoNumbers())).isEqualTo(LottoRank.NOT_MATCH);
    }

    @Test
    void createLottoNumberTest() {
        assertThat(new Lotto().getLottoNumbers().getNumbers()).isEqualTo(6);
    }

    @Test
    void invalidNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8);
        }).withMessage(LottoNumbers.GRATER_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5), 8);
        }).withMessage(LottoNumbers.LESS_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 5), 8);
        }).withMessage(LottoNumbers.DUPLICATED_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(-1, 2, 3, 4, 5, 6), 8);
        }).withMessage(LottoNumbers.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 46), 8);
        }).withMessage(LottoNumbers.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).withMessage(LottoNumbers.DUPLICATED_BONUS_NUMBER_ERROR);
    }
}
