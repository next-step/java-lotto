package lotto.step2;

import lotto.step2.domain.LotteryStore;
import lotto.step2.domain.Lotto;
import lotto.step2.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개 랜덤값을 가지고 있다.")
    void createLottoNumber() {
        Lotto lotto = new Lotto(1000);
        List<Integer> numbers =  lotto.getLottoNumber().getNumber();
        System.out.println(numbers);
        assertThat(numbers).size().isEqualTo(6);
    }

    @Test
    @DisplayName("로또 가격은 개당 1000원이다")
    void createLottoPrice() {
        Lotto lotto = new Lotto(1000);
        int price = lotto.getLottoPrice().getPrice();
        assertThat(price).isEqualTo(1000);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumber")
    @DisplayName("통계 테스트")
    void statics(List<Integer> list, int count) {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(new Number(lottoNumber));
        assertThat(lotto.getMatch(list)).isEqualTo(count);
    }

    private static Stream<Arguments> provideWinnerNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 35, 37, 26), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 37, 26), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 26), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 12), 6)
        );
    }


}