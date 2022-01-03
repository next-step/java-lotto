package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.utils.FixNumberStrategy;
import lotto.utils.NumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private Lotto lotto;
    private NumberStrategy numberStrategy;

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

    @ParameterizedTest
    @MethodSource("invalidLottoNumber")
    @DisplayName("범위 밖의 숫자, 개수가 6보다 작은 숫자, 중복된 숫자는 로또를 생성하지 않고 각각 알맞은 예외를 발생시킨다.")
    void out_of_range_number_is_invalid(NumberStrategy invalidNumberStrategy, String exception) {
        assertThatThrownBy(() -> new Lotto(invalidNumberStrategy))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining(exception);
    }

    private static Stream<Arguments> invalidLottoNumber() {
        return Stream.of(
            Arguments
                .of(new FixNumberStrategy(Arrays.asList(-1, 0, 46, 47, 48, 49)),
                    OUT_OF_RANGE_EXCEPTION),
            Arguments
                .of(new FixNumberStrategy(Arrays.asList(1, 2, 3, 4, 5)),
                    INVALID_SIZE_EXCEPTION),
            Arguments
                .of(new FixNumberStrategy(Arrays.asList(1, 1, 3, 4, 5, 6)),
                    DUPLICATION_EXCEPTION)
        );
    }


}