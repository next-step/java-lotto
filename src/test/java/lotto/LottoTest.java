package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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

        winnerLotto = new Lotto(new LottoNumber(winnerNumbers,7));
        firstPlaceNumber = new Lotto(new LottoNumber(winnerNumbers,7));
        secondPlaceNumber = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 40), 7));
        thirdPlaceNumber = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 20, 40), 8));
        fourthPlaceNumber = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 12, 20, 40), 8));
        notMatchNumber = new Lotto(new LottoNumber(Arrays.asList(1, 2, 9, 12, 20, 40), 8));
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(firstPlaceNumber.getRank(winnerLotto.getLottoNumber())).isEqualTo(LottoRank.FIRST);
        assertThat(secondPlaceNumber.getRank(winnerLotto.getLottoNumber())).isEqualTo(LottoRank.SECOND);
        assertThat(thirdPlaceNumber.getRank(winnerLotto.getLottoNumber())).isEqualTo(LottoRank.THIRD);
        assertThat(fourthPlaceNumber.getRank(winnerLotto.getLottoNumber())).isEqualTo(LottoRank.FOURTH);
        assertThat(notMatchNumber.getRank(winnerLotto.getLottoNumber())).isEqualTo(LottoRank.NOT_MATCH);
    }

    @Test
    void createLottoNumberTest() {
        assertThat(new Lotto().getLottoNumber().getNumbers()).isEqualTo(6);
    }

    @Test
    void invalidNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8);
        }).withMessage(LottoNumber.GRATER_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5), 8);
        }).withMessage(LottoNumber.LESS_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 5), 8);
        }).withMessage(LottoNumber.DUPLICATED_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(-1, 2, 3, 4, 5, 6), 8);
        }).withMessage(LottoNumber.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 46), 8);
        }).withMessage(LottoNumber.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).withMessage(LottoNumber.DUPLICATED_BONUS_NUMBER_ERROR);
    }
}
