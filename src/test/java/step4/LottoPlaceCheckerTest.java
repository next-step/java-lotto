package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lottos;
import step4.lottoPlace.LastWeekLotto;
import step4.lottoPlace.LottoPlace;
import step4.lottoPlace.LottoPlaceChecker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPlaceCheckerTest {
    @ParameterizedTest
    @DisplayName("일치하는 번호 갯수로 등수를 구한다")
    @CsvSource(value = {"3:false:FIFTH", "4:true:FORTH", "5:false:THIRD", "5:true:SECOND", "6:true:FIRST"}, delimiter = ':')
    public void getPlace(int correctNum, boolean isBonusNumCorrect, LottoPlace expected) {
        //given, when
        LottoPlace lottoPlace = LottoPlace.findPlaceByCorrectNum(correctNum, isBonusNumCorrect);

        //then
        assertThat(lottoPlace).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("등수에 따라 상금을 구한다")
    @CsvSource(value = {"FIFTH:5000", "FORTH:50000", "THIRD:1500000", "SECOND:30000000", "FIRST:2000000000"}, delimiter = ':')
    public void getPriceByPlace(LottoPlace lottoPlace, int expected) {
        //given, when
        int price = lottoPlace.getPrice();

        //then
        assertThat(price).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구매한 로또들의 전체 상금을 구한다")
    @CsvSource(value = {"FIRST:SECOND:2030000000", "THIRD:FORTH:1550000", "FIRST:FORTH:2000050000"}, delimiter = ':')
    public void getTotalPrice(LottoPlace place1, LottoPlace place2, long expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        LottoPlaceChecker lottoPlaceChecker = LottoPlaceChecker.of(LastWeekLotto.of(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            7
        ));
        Method calculateTotalPrice = lottoPlaceChecker.getClass()
            .getDeclaredMethod("calculateTotalPrice", List.class);
        calculateTotalPrice.setAccessible(true);

        //when
        long price = (long) calculateTotalPrice.invoke(lottoPlaceChecker, Arrays.asList(place1, place2));

        //then
        assertThat(price).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("전체 상금과 구매한 비용의 비율을 구한다.")
    @MethodSource("getRateOfTotalPriceSource")
    public void getRateOfTotalPrice(List<LottoPlace> lottoPlaces, int cost, BigDecimal expected) {
        //given
        LottoPlaceChecker lottoPlaceChecker = LottoPlaceChecker.of(LastWeekLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6),
            7
        ));

        //when
        BigDecimal result = lottoPlaceChecker.calculateWinnerRate(lottoPlaces, cost);

        //then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @ParameterizedTest
    @DisplayName("로또 번호와 지난 주 로또 번호로 등수 확인")
    @MethodSource("getLottoPlaceSource")
    public void checkPlace(List<Integer> nums, List<Integer> lastWeekNums, int bonusNum, LottoPlace expected) {
        //given
        Lottos lottos = Lottos.createLottos(0, Collections.singletonList(nums), 1000);
        LastWeekLotto lastWeekLotto = LastWeekLotto.of(lastWeekNums, bonusNum);
        LottoPlaceChecker placeChecker = LottoPlaceChecker.of(lastWeekLotto);

        //when
        List<LottoPlace> lottoPlace = placeChecker.getLottoPlace(lottos);

        //then
        for (LottoPlace place : lottoPlace) {
            assertThat(place).isEqualTo(expected);
        }
    }

    static Stream<Arguments> getLottoPlaceSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoPlace.FIRST),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 7), Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoPlace.SECOND),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 7), Arrays.asList(1, 2, 3, 4, 5, 6), 8, LottoPlace.THIRD),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoPlace.FORTH),
            Arguments.arguments(Arrays.asList(1, 2, 3, 9, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoPlace.FIFTH)
        );
    }

    static Stream<Arguments> getRateOfTotalPriceSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(LottoPlace.FIRST, LottoPlace.SECOND), 2000, BigDecimal.valueOf(1015000)),
            Arguments.arguments(Arrays.asList(LottoPlace.THIRD, LottoPlace.FORTH), 2000, BigDecimal.valueOf(775)),
            Arguments.arguments(Arrays.asList(LottoPlace.FIRST, LottoPlace.FORTH), 2000, BigDecimal.valueOf(1000025))
        );
    }
}
