package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.*;
import step2.lottoPlace.LottoPlace;
import step2.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAutoTest {

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 제대로 입력}")
    @CsvSource(value = {"1,2,3,4,5,6", "10,11,12,13,14,15", "46,45,44,43,42,41"}, delimiter = ':')
    public void successLottoInput(String input) {
        //given, when, then
        InputView.getLastWeekLottoNum(input);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 잘못 입력")
    @CsvSource(value = {"1,2,3,4,5", "-10,11,12,13,14,15", "46,45,44,43,42,41,40,39"}, delimiter = ':')
    public void failLottoInput(String input) {
        //given, when, then
        assertThatThrownBy(() -> {
            InputView.getLastWeekLottoNum(input);
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
        int lottoSize = (int) lotto.getLottoNums().stream()
            .distinct()
            .count();

        //then
        assertThat(lottoSize).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("일치하는 번호 숫자에 따라 등수를 구한다")
    @CsvSource(value = {"3:FORTH", "4:THIRD", "5:SECOND", "6:FIRST"}, delimiter = ':')
    public void getPlaceByCorrectNum(int correctNum, LottoPlace expected) {
        //given, when
        LottoPlace lottoPlace = LottoPlace.findPlaceByCorrectNum(correctNum);

        //then
        assertThat(lottoPlace).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("내 로또번호와 지난 주 로또번호를 합쳐서 중복을 제거한 카운트로 등수를 구한다.")
    @CsvSource(value = {"9:FORTH", "8:THIRD", "7:SECOND", "6:FIRST"}, delimiter = ':')
    public void getPlaceByDistinctNum(int distinctNum, LottoPlace expected) {
        //given, when
        LottoPlace lottoPlace = LottoPlace.findPlaceByDistinctNum(distinctNum);

        //then
        assertThat(lottoPlace).isEqualTo(expected);
    }
//
    @ParameterizedTest
    @DisplayName("등수에 따라 상금을 구한다")
    @CsvSource(value = {"FORTH:5000", "THIRD:50000", "SECOND:1500000", "FIRST:2000000000"}, delimiter = ':')
    public void getPriceByPlace(LottoPlace lottoPlace, int expected) {
        //given, when
        int price = lottoPlace.getPrice();

        //then
        assertThat(price).isEqualTo(expected);
    }
}
