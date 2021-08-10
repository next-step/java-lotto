package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lotto;
import step4.lottoPlace.LastWeekLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @RepeatedTest(50)
    @DisplayName("중복되지 않는 로또 번호 6개 생성")
    public void createLottoNum() {
        //given
        int expected = 6;

        //when
        Lotto lotto = Lotto.createLotto();
        int lottoSize = (int) lotto.getLottoNums()
            .stream()
            .distinct()
            .count();

        //then
        assertThat(lottoSize).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("직접 로또 번호를 입력")
    @MethodSource("lottoNumSource")
    public void createLottoNumManual(List<Integer> manualLottoNums) {
        //given
        int expected = 6;

        //when
        Lotto lotto = Lotto.createLotto(manualLottoNums);
        int lottoSize = (int) lotto.getLottoNums()
            .stream()
            .distinct()
            .count();

        //then
        assertThat(lottoSize).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또번호와 비교하여 일치하는 갯수를 카운트")
    @MethodSource("lottoNumAndLastWeekLottoNumSource")
    public void countCorrectNums(List<Integer> manualLottoNums, List<Integer> lastWeekLottoNum, int bonusNum, int expected) {
        //given
        Lotto lotto = Lotto.createLotto(manualLottoNums);
        LastWeekLotto lastWeekLotto = LastWeekLotto.of(lastWeekLottoNum, bonusNum);

        //when
        int count = lotto.countCorrectNums(lastWeekLotto);

        //then
        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호를 갖고 있는지 확인")
    @MethodSource("lottoNumAndBonusNumSource")
    public void checkBonusNum(List<Integer> manualLottoNums, List<Integer> lastWeekLottoNum, int bonusNum, boolean expected) {
        //given
        Lotto lotto = Lotto.createLotto(manualLottoNums);
        LastWeekLotto lastWeekLotto = LastWeekLotto.of(lastWeekLottoNum, bonusNum);

        //when
        boolean result = lotto.isLottoNumContainsBonusNum(lastWeekLotto);

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13)),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20))
        );
    }

    static Stream<Arguments> lottoNumAndLastWeekLottoNumSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, 6),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13), Arrays.asList(3, 4, 5, 6, 7, 8), 9, 1),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20), Arrays.asList(15, 16, 1, 2, 3, 4), 9, 2)
        );
    }

    static Stream<Arguments> lottoNumAndBonusNumSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6, true),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13), Arrays.asList(3, 4, 5, 6, 7, 8), 15, false),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20), Arrays.asList(15, 16, 1, 2, 3, 4), 20, true)
        );
    }
}
