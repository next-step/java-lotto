package Lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    private static final int LOTTO_NUMBER_ONE = 1;
    private static final int LOTTO_NUMBER_TWO = 2;
    private static final int LOTTO_NUMBER_THREE = 3;
    private static final int LOTTO_NUMBER_FOUR = 4;
    private static final int LOTTO_NUMBER_FIVE = 5;
    private static final int LOTTO_NUMBER_SIX = 6;
    private static final int PROPER_LOTTONUMBER_COUNT = 6;
    private static final int PREDICT_MATCH_NUMBERS = 6;

    @Test
    @DisplayName("로또 생성자 테스트 적절하지 않은 개수로 생성.")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO)
                )
        )).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_SIX),
                        new LottoNumber(LOTTO_NUMBER_SIX),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성자 테스트 적절한 개수로 생성")
    public void constructorSuccessTest() {
        final Lotto lotto = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        int lottoCount = lotto.getLotto().size();
        assertThat(lottoCount).isEqualTo(PROPER_LOTTONUMBER_COUNT);
    }

    @Test
    @DisplayName("로또 당첨번호 비교하는 테스트")
    public void compareLuckyNumber() {
        final Lotto lotto = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        final Lotto luckyNumber = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        int MatchNumbers = lotto.countMatchNumbers(luckyNumber);
        assertThat(MatchNumbers).isEqualTo(PREDICT_MATCH_NUMBERS);
    }

    @Test
    @DisplayName("6개의 로또번호 중 한개의 특정로또 번호가 포함되어있는지 확인")
    public void isContainLottoNumber() {
        final Lotto lotto = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        final LottoNumber numberOne = new LottoNumber(1);
        final LottoNumber numberSeven = new LottoNumber(7);
        boolean predictContain = lotto.isContain(numberOne);
        boolean predictNotContain = lotto.isContain(numberSeven);
        assertThat(predictContain).isEqualTo(true);
        assertThat(predictNotContain).isEqualTo(false);
    }

}