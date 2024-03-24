package lotto;

import lotto.domain.AmountEnum;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.MyLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {
    @DisplayName("로또 구매 갯수를 구한다.")
    @Test
    public void getBuyLottoCount() {
        //given
        int amount = 14000;
        MyLottos myLottos = MyLottos.rollLottos(amount);

        //when
        Integer lottoCount = myLottos.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(14);
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
        Lotto winNumber = new Lotto("1,2,3,4,10,6");

        Lotto currentNumber = new Lotto("1,2,3,7,9,10");

        //when
        AmountEnum amountEnum = currentNumber.getAmountEnumCompareWinNumber(winNumber, new LottoNumber(11));

        //then
        assertThat(amountEnum).isEqualTo(AmountEnum.FOURTH);
    }

    static Stream<Arguments> getAmountData() {
        return Stream.of(
                Arguments.of("1,2,24,5,11,6", 5000),
                Arguments.of("1,2,3,5,11,6", 50000),
                Arguments.of("1,2,3,4,12,6", 1500000),
                Arguments.of("1,2,3,4,11,6", 30000000),
                Arguments.of("1,2,3,4,10,6", 2000000000)
        );
    }

    @DisplayName("맞춘 숫자갯수만큼 당첨금이 나온다.")
    @ParameterizedTest
    @MethodSource("getAmountData")
    public void getAmount(String currentNumbers, int result) {
        //given
        Lotto winNumber = new Lotto("1,2,3,4,10,6");

        Lotto currentNumber = new Lotto(currentNumbers);

        //when
        AmountEnum amountEnum = currentNumber.getAmountEnumCompareWinNumber(winNumber, new LottoNumber(11));

        //then
        assertThat(amountEnum.getAmount()).isEqualTo(result);
    }

    @DisplayName("로또를 생성한 다음 문자열로 변환한다.")
    @Test
    public void getLottoNumbersToString() {
        //given
        Lotto lotto = new Lotto("1,2,3,4,10,6");

        //when & then
        assertThat(lotto.getNumbersToString()).isEqualTo("[1, 2, 3, 4, 10, 6]");
    }

    @DisplayName("로또의 숫자가 중복되면 예외를 발생시킨다.")
    @Test
    public void getDuplicatedLottoNumbers() {
        //given & when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto("1,2,3,10,10,6");
                }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("로또의 숫자가 5개가 일치하고 보너스 번호가 일치하면 2등이다.")
    @Test
    public void getSecondAmount() {
        //given
        Lotto winNumber = new Lotto("1,2,3,4,10,6");

        Lotto currentNumber = new Lotto("1,2,3,4,10,7");

        int bonusNumber = 7;
        //when
        AmountEnum amountEnum = currentNumber.getAmountEnumCompareWinNumber(winNumber, new LottoNumber(bonusNumber));

        //then
        assertThat(amountEnum).isEqualTo(AmountEnum.SECOND);
    }

    @DisplayName("보너스 번호가 당첨 번호에 들어있으면 예외가 발생한다.")
    @Test
    public void winnerNumbersIncludeBonusNumber() {
        //given
        Lotto winNumber = new Lotto("1,2,3,4,10,6");

        Lotto currentNumber = new Lotto("1,2,3,4,10,7");

        int bonusNumber = 4;

        //when&then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    currentNumber.getAmountEnumCompareWinNumber(winNumber, new LottoNumber(bonusNumber));
                }).withMessageMatching("보너스 번호와 당첨 번호가 중복됩니다.");
    }
}
