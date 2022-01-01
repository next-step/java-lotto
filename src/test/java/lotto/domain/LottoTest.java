package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.FixNumberStrategy;
import lotto.utils.NumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;
    private NumberStrategy numberStrategy;

    private static final Set<Integer> winningNumbers = new HashSet<>(
        Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final List<Integer> fixNumbers = new ArrayList<>(
        Arrays.asList(1, 3, 4, 5, 6, 7));

    private static final String OUT_OF_RANGE_EXCEPTION = "로또 숫자는 1에서 45까지 입니다.";
    private static final String INVALID_SIZE_EXCEPTION = "로또 숫자는 6개 입니다.";
    private static final String DUPLICATION_EXCEPTION = "로또 숫자는 중복되지 않는 6자리 수여야 합니다.";


    void setUp() {
        numberStrategy = new FixNumberStrategy(fixNumbers);
        lotto = new Lotto(numberStrategy);
    }

    @Test
    @DisplayName("숫자 생성에 따른 올바를 로또를 생성한다.")
    void create_lotto() {
        //given
        setUp();

        //when
        List<Integer> lottoNumbers = lotto.getLottoNumber();
        List<Integer> fixLottoNumbers = numberStrategy.lottoNumbers();

        //then
        assertTrue(Arrays.equals(lottoNumbers.toArray(), fixLottoNumbers.toArray()));
    }

    @Test
    @DisplayName("범위 밖의 숫자로는 로또를 생성하지 않고 예외를 발생시킨다.")
    void out_of_range_number_is_invalid() {
        //given
        List<Integer> invalidFixNumbers = new ArrayList<>(Arrays.asList(-1, 0, 46, 47, 48, 49));
        NumberStrategy numberStrategy = new FixNumberStrategy(invalidFixNumbers);

        //when
        Exception exception =
            assertThrows(IllegalStateException.class, () -> new Lotto(numberStrategy));

        //then
        assertEquals(exception.getMessage(), OUT_OF_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("숫자의 갯수가 6개가 아니면 로또를 생성하지 않고 예외를 발생시킨다.")
    void number_size_not_six_is_invalid() {
        //given
        List<Integer> invalidFixNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        NumberStrategy numberStrategy = new FixNumberStrategy(invalidFixNumbers);

        //when
        Exception exception =
            assertThrows(IllegalStateException.class, () -> new Lotto(numberStrategy));

        //then
        assertEquals(exception.getMessage(), INVALID_SIZE_EXCEPTION);
    }

    @Test
    @DisplayName("중복된 숫자로는 로또를 생성하지 않고 예외를 발생시킨다.")
    void duplicated_number_is_invalid() {
        //given
        List<Integer> invalidFixNumbers = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 5, 6));
        NumberStrategy numberStrategy = new FixNumberStrategy(invalidFixNumbers);

        //when
        Exception exception =
            assertThrows(IllegalStateException.class, () -> new Lotto(numberStrategy));

        //then
        assertEquals(exception.getMessage(), DUPLICATION_EXCEPTION);
    }


    @Test
    @DisplayName("당첨번호와 일치하는 로또 번호의 갯수를 올바르게 반환한다.")
    void get_matchCount() {
        //given
        setUp();

        //when
        int matchCount = lotto.matchCount(winningNumbers);
        int count = 0;
        for (int i = 0; i < lotto.getLottoNumber().size(); i++) {
            count += Collections.frequency(winningNumbers, lotto.getLottoNumber().get(i));
        }

        //then
        assertEquals(matchCount, count);
    }

}