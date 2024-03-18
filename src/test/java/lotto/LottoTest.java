package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    static Stream<Arguments> getAmountData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 24, 5, 11, 6), 5000),
                Arguments.of(Arrays.asList(1, 2, 3, 5, 11, 6), 50000),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 6), 1500000),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 10, 6), 2000000000)
        );
    }

    @DisplayName("로또 구매 갯수를 구한다.")
    @Test
    public void getBuyLottoNumber() {
        //given
        int amount = 14000;
        Seller seller = new Seller();

        //when
        int buyLottoNumber = seller.getBuyLottoNumber(amount);

        //then
        assertThat(buyLottoNumber).isEqualTo(14);
    }

    @DisplayName("로또를 생성할때 숫자 6개가 나온다.")
    @Test
    public void getLottoNumbers() {
        //given
        Lotto lotto = new Lotto();

        //when & then
        assertThat(lotto.getNumberSize()).isEqualTo(6);
    }

    @DisplayName("입력받은 당첨 번호와 현재 로또 번호를 비교한다.")
    @Test
    public void compareWinLottoNumbersAndCurrentLottoNumbers() {
        //given
        List<Integer> winNumbersInput = List.of(1, 2, 3, 4, 10, 6);
        Lotto winNumber = new Lotto(winNumbersInput);

        List<Integer> currentNumbers = List.of(1, 2, 3, 7, 9, 10);
        Lotto currentNumber = new Lotto(currentNumbers);

        //when
        long matchedCount = currentNumber.compareWinNumber(winNumber);

        //then
        assertThat(matchedCount).isEqualTo(4L);
    }

    @DisplayName("맞춘 숫자갯수만큼 당첨금이 나온다.")
    @ParameterizedTest
    @MethodSource("getAmountData")
    public void getAmount(List<Integer> input, int result) {
        //given
        List<Integer> winNumbersInput = List.of(1, 2, 3, 4, 10, 6);
        Lotto winNumber = new Lotto(winNumbersInput);

        List<Integer> currentNumbers = input;
        Lotto currentNumber = new Lotto(currentNumbers);

        int matchedCount = currentNumber.compareWinNumber(winNumber);

        //when
        int amount = Amount.getAmount(matchedCount);

        //then
        assertThat(amount).isEqualTo(result);
    }
    @DisplayName("로또를 생성한 다음 문자열로 변환한다.")
    @Test
    public void getLottoNumbersToString() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 6));

        //when & then
        assertThat(lotto.getNumbersToString()).isEqualTo("[1, 2, 3, 4, 10, 6]");
    }
}
