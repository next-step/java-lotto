package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @DisplayName("자동 로또를 팔았을 경우 입력한 로또의 장수와 판매한 로또의 장수가 일치 하는 지 테스트")
    @MethodSource("provideNumberOfLotto")
    void LottoCountIsEqualWithNumberOfAutoInput(int input, int expected) {
        int actual = LottoStore.sellAutoLottoTicket(input).size();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberOfLotto() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(15, 15),
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @DisplayName("수동 로또를 팔았을 경우 입력한 로또 문자열 숫자와 판매한 로또 티켓의 숫자가 일치하는 지 테스트")
    @MethodSource("provideNumberStrings")
    void LottoCountIsEqualWithLottoNumberStrings(List<String> stringManualNumbers, List<LottoNumber> lottoNumbers) {
        List<LottoTicket> lottoTickets = LottoStore.sellManualLottoTicket(stringManualNumbers);

        for (LottoTicket actual : lottoTickets) {
            lottoNumbers.forEach((lottoNumber -> {
                assertThat(actual.has(lottoNumber)).isTrue();
            }));
        }
    }

    private static Stream<Arguments> provideNumberStrings() {
        return Stream.of(
                Arguments.of(Arrays.asList("1,2,3,4,5,6"),
                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        );
    }

}
