package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

  static Lotto lotto_number1to6;

  @BeforeAll
  static void setUp() {
    lotto_number1to6 = new Lotto(Arrays.asList(
        new LottoNumber(1, false),
        new LottoNumber(2, false),
        new LottoNumber(3, false),
        new LottoNumber(4, false),
        new LottoNumber(5, false),
        new LottoNumber(6, false)
    ));
  }

  @ParameterizedTest
  @MethodSource("numberListProvider")
  void newInstanceByStrArr(String[] strArr, int bonusNumber, Lotto lotto) {
    assertThat(
        WinningLotto.newInstanceByStrArr(strArr, new LottoNumber(bonusNumber, true)).getLotto())
        .isEqualTo(lotto);
  }

  static Stream<Arguments> numberListProvider() {
    return Stream.of(
        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, 7, lotto_number1to6),
        arguments("1, 2, 3, 4, 5, 6".split(","), 7, lotto_number1to6)
    );
  }

  @ParameterizedTest
  @MethodSource("numberListWithPrizeTierProvider")
  void getPrizeTier(String[] strArr, int bonusNumber, Lotto numbers, PrizeTier prizeTier) {
    WinningLotto winningLotto = WinningLotto
        .newInstanceByStrArr(strArr, new LottoNumber(bonusNumber, true));

    assertThat(winningLotto.getPrizeTier(numbers)).isEqualTo(prizeTier);
  }

  static Stream<Arguments> numberListWithPrizeTierProvider() {

    return Stream.of(
//        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, 7,
//            lotto_number1to6,
//            PrizeTier.MATCH_SIX
//        ),
        arguments(new String[]{"1", "2", "3", "4", "5", "7"}, 6,
            lotto_number1to6,
            PrizeTier.MATCH_FIVE_WITH_BONUS
        )
//        ,
//        arguments(new String[]{"1", "2", "3", "4", "5", "7"}, 8,
//            lotto_number1to6,
//            PrizeTier.MATCH_FIVE
//        ),
//        arguments(new String[]{"1", "2", "3", "4", "7", "8"}, 9,
//            lotto_number1to6,
//            PrizeTier.MATCH_FOUR
//        ),
//        arguments(new String[]{"1", "2", "3", "7", "8", "9"}, 10,
//            lotto_number1to6,
//            PrizeTier.MATCH_THREE
//        ),
//        arguments(new String[]{"1", "2", "7", "8", "9", "10"}, 11,
//            lotto_number1to6,
//            PrizeTier.MATCH_TWO
//        ), arguments(new String[]{"1", "7", "8", "9", "10", "11"}, 12,
//            lotto_number1to6,
//            PrizeTier.MATCH_ONE
//        ),
//        arguments(new String[]{"7", "8", "9", "10", "11", "12"}, 13,
//            lotto_number1to6,
//            PrizeTier.MATCH_ZERO
//        )
    );
  }
}