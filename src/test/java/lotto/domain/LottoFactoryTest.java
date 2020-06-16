package lotto.domain;

import lotto.StringParser;
import lotto.view.PurchaseLottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoFactoryTest {

    @DisplayName("구입 금액이 1000원 미만인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -4, 999})
    void whenInputNegativeThenExceptionTest(int price) {

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.createLottos(new PurchaseLottoInput(price, Collections.emptyList()))
        );
    }

    @DisplayName("수동 구매 개수가 (구매 금액 / 로또 가격) 보다 클 경우 예외가 발생한다")
    @Test
    void manualCountExceedPurchaseCountExceptionTest() {
        // given
        int price = 3000;
        List<String> numbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8", "5,6,7,8,9,10");

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoFactory.createLottos(new PurchaseLottoInput(price, numbers))
        );
    }

    @DisplayName("구입 금액을 입력하면 로또 가격으로 나눈 수 만큼의 로또를 발급한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "3000, 3", "10000, 10"})
    void whenInputPriceThenGenerateLottoTest(int price, int expected) {

        // when
        List<Lotto> lottos = LottoFactory.createLottos(new PurchaseLottoInput(price, Collections.emptyList()));

        System.out.println(lottos.get(0).getNumbers());

        // then
        assertThat(lottos).hasSize(expected);
    }

    @DisplayName("수동 입력 로또 구매 시 구매 개수만큼 로또가 생성된다.")
    @ParameterizedTest
    @MethodSource("manualNumbersProvider")
    void manualLottoSizeTest(int price, List<String> manualNumbers) {

        // when
        List<Lotto> lottos = LottoFactory.createLottos(new PurchaseLottoInput(price, manualNumbers));

        // then
        assertThat(lottos).hasSize(manualNumbers.size());
    }

    @DisplayName("수동 입력 로또 구매 시 입력된 번호와 생성된 로또 번호가 같아야 한다.")
    @ParameterizedTest
    @MethodSource("manualNumbersProvider")
    void manualLottoNumbersTest(int price, List<String> manualNumbers) {

        // when
        List<Lotto> lottos = LottoFactory.createLottos(new PurchaseLottoInput(price, manualNumbers));

        // then
        for (int i = 0; i < lottos.size(); i++) {
            assertIterableEquals(lottos.get(i).getNumbers(), StringParser.getParseNumbers(manualNumbers.get(i)));
        }
    }

    static Stream<Arguments> manualNumbersProvider() {
        return Stream.of(
                arguments(3000, Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 6, 7")),
                arguments(2000, Arrays.asList("1, 2, 3, 4, 5, 7", "1, 4, 6, 7, 9, 10"))
        );
    }

    @DisplayName("수동 입력 로또와 자동 입력 로또를 같이 구매 시 생성된 로또 개수는 합산되어야 한다.")
    @ParameterizedTest
    @MethodSource("manualNumbersAndSizeProvider")
    void autoAndManualNumbersTest(int price, List<String> manualNumbers, int size){
        // when
        List<Lotto> lottos = LottoFactory.createLottos(new PurchaseLottoInput(price, manualNumbers));

        // then
        assertThat(lottos).hasSize(size);
    }

    static Stream<Arguments> manualNumbersAndSizeProvider() {
        return Stream.of(
                arguments(6000, Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 6, 7"), 6),
                arguments(5000, Arrays.asList("1, 2, 3, 4, 5, 7", "1, 4, 6, 7, 9, 10"), 5)
        );
    }
}
