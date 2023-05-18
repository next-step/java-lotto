package study.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class TestLottery {

    private Lottery lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lottery();
    }
    

    @Test
    @DisplayName("Lottery 객체 - 생성 테스트")
    public void test_lottery() {
        assertDoesNotThrow(() -> new Lottery());

        assertThat(lotto.getLottery().size())
            .isEqualTo(6);
    }


    @Test
    @DisplayName("Lottery 객체 - 당첨번호 Null 입력 테스트")
    public void test_lottery_win_null() {
        assertThatThrownBy(() -> lotto.setWinNumbers(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호를 입력해주세요");
    }


    static Stream<Arguments> wrongSizeWinNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest(name = "Lottery 객체 - 당첨번호 6자리 아닌경우 테스트")
    @MethodSource("wrongSizeWinNumbers")
    public void test_lottery_win_wrong_size(List<Integer> winNumbers) {
        assertThatThrownBy(() -> lotto.setWinNumbers(winNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호 6자리를 입력해주세요");
    }


    @Test
    @DisplayName("Lottery 객체 - 당첨번호 전체 매칭 테스트")
    public void test_lottery_win_match_count() {
        List<Integer> winNumbers = lotto.getLottery();
        lotto.setWinNumbers(winNumbers);

        assertThat(lotto.getMatchCount())
            .isEqualTo(6);
    }

}
