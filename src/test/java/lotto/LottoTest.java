package lotto;

import lotto.domain.Lotto;
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

        winnerLotto = new Lotto(winnerNumbers);
        firstPlaceNumber = new Lotto(winnerNumbers);
        secondPlaceNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40));
        thirdPlaceNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 20, 40));
        fourthPlaceNumber = new Lotto(Arrays.asList(1, 2, 3, 12, 20, 40));
        notMatchNumber = new Lotto(Arrays.asList(1, 2, 9, 12, 20, 40));
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(firstPlaceNumber.getRank(winnerLotto)).isEqualTo(LottoRank.FIRST);
        assertThat(secondPlaceNumber.getRank(winnerLotto)).isEqualTo(LottoRank.SECOND);
        assertThat(thirdPlaceNumber.getRank(winnerLotto)).isEqualTo(LottoRank.THIRD);
        assertThat(fourthPlaceNumber.getRank(winnerLotto)).isEqualTo(LottoRank.FOURTH);
        assertThat(notMatchNumber.getRank(winnerLotto)).isEqualTo(LottoRank.NOT_MATCH);
    }

    @Test
    void createLottoNumberTest() {
        assertThat(new Lotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    void invalidNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).withMessage(Lotto.GRATER_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).withMessage(Lotto.LESS_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).withMessage(Lotto.DUPLICATED_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(-1, 2, 3, 4, 5, 6));
        }).withMessage(Lotto.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).withMessage(Lotto.INVALID_RANGE_NUMBER_ERROR);
    }
}
