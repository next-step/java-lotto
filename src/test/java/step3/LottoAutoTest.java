package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.Shop;
import step3.lottoPlace.LastWeekLotto;
import step3.lottoPlace.LottoPlace;
import step3.lottoPlace.LottoPlaceChecker;
import step3.view.InputView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAutoTest {

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 제대로 입력}")
    @CsvSource(value = {"1,2,3,4,5,6:7", "10,11,12,13,14,15:16", "45,44,43,42,41,40:39"}, delimiter = ':')
    public void successLottoInput(String input, int bonus) {
        //given, when, then
        InputView.getLastWeekLottoNum(input, bonus);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 잘못 입력")
    @CsvSource(value = {"1,2,3,4,5:6", "-10,11,12,13,14,15:16", "46,45,44,43,42,41,40,39:38"}, delimiter = ':')
    public void failLottoInput(String input, int bonus) {
        //given, when, then
        assertThatThrownBy(() -> {
            InputView.getLastWeekLottoNum(input, bonus);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("금액으로 로또 구입 개수 찾기")
    @CsvSource(value = {"1000:1", "10000:10", "15000:15", "11500:11"}, delimiter = ':')
    public void buyLotto(int input, int expected) {
        //given, when
        Lottos lottos = Shop.buyLotto(input);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @DisplayName("중복되지 않는 로또 번호 6개 생성")
    @RepeatedTest(50)
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
    @DisplayName("일치하는 번호 갯수로 등수를 구한다")
    @CsvSource(value = {"3:false:FIFTH", "4:true:FORTH", "5:false:THIRD", "5:true:SECOND", "6:true:FIRST"}, delimiter = ':')
    public void getPlaceByDistinctNum(int correctNum, boolean isBonusNumCorrect, LottoPlace expected) {
        //given, when
        LottoPlace lottoPlace = LottoPlace.findPlaceByCorrectNum(correctNum, isBonusNumCorrect);

        //then
        assertThat(lottoPlace).isEqualTo(expected);
    }

    //
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
        LottoPlaceChecker lottoPlaceChecker = LottoPlaceChecker.of(LastWeekLotto.of(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            7
        ));

        //when
        BigDecimal result = lottoPlaceChecker.calculateWinnerRate(lottoPlaces, cost);

        //then
        assertThat(result).isEqualByComparingTo(expected);
    }

    static Stream<Arguments> getRateOfTotalPriceSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(LottoPlace.FIRST, LottoPlace.SECOND), 2000, BigDecimal.valueOf(1015000)),
            Arguments.arguments(Arrays.asList(LottoPlace.THIRD, LottoPlace.FORTH), 2000, BigDecimal.valueOf(775)),
            Arguments.arguments(Arrays.asList(LottoPlace.FIRST, LottoPlace.FORTH), 2000, BigDecimal.valueOf(1000025))
        );
    }
}
