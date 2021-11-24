package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static lotto.Prize.FIFTH;
import static lotto.Prize.FIRST;
import static lotto.Prize.FOURTH;
import static lotto.Prize.LOSE;
import static lotto.Prize.SECOND;
import static lotto.Prize.SEVENTH;
import static lotto.Prize.SIXTH;
import static lotto.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
    @ParameterizedTest
    @MethodSource("constructorMethodSource")
    @DisplayName("Wallet 은 돈을 입력 받아 자신을 생성할 수 있다.")
    void constructorMethod(int money) {
        // given
        Wallet wallet = new Wallet(money);

        // when

        // then
        assertThat(wallet).isEqualTo(new Wallet(money));
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of(10000),
                Arguments.of(20000)
        );
    }

    @ParameterizedTest
    @MethodSource("buyLottoMethodSource")
    @DisplayName("Wallet 은 Lotto 를 여러장 구매할 수 있다.")
    void buyLottoMethod(int money) {
        // given
        final Money unitPrice = new Money(1000);
        Wallet wallet = new Wallet(money);

        // when
        wallet.buyLotto(unitPrice);

        // then
        assertThat(wallet).isEqualTo(new Wallet(money, new Money(money).quotient(unitPrice)));
    }

    static Stream<Arguments> buyLottoMethodSource() {
        return Stream.of(
                Arguments.of(10000),
                Arguments.of(20000)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoResultByPrizeSource")
    @DisplayName("Wallet 은 LottoResult 를 파라미터로 받아 자신의 Lotto 를 Prize 로 반환할 수 있다.")
    void lottoResultByPrize(String winNumber, String bonusNumber, Prize targetPrize) {
        // given
        Wallet wallet = new Wallet(new Money(10000), Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6")));
        LottoResult lottoResult = new LottoResult(winNumber, bonusNumber);

        // when
        final int ea = wallet.lottoResultByPrize(lottoResult, targetPrize);

        // then
        assertThat(ea).isEqualTo(1);
    }

    static Stream<Arguments> lottoResultByPrizeSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "7", FIRST),
                Arguments.of("1, 2, 3, 4, 5, 7", "6", SECOND),
                Arguments.of("1, 2, 3, 4, 5, 8", "7", THIRD),
                Arguments.of("1, 2, 3, 4, 8, 9", "7", FOURTH),
                Arguments.of("1, 2, 3, 8, 9, 10", "7", FIFTH),
                Arguments.of("1, 2, 8, 9, 10, 11", "7", SIXTH),
                Arguments.of("1, 8, 9, 10, 11, 12", "7", SEVENTH),
                Arguments.of("8, 9, 10, 11, 12, 13", "7", LOSE)
        );
    }
}
