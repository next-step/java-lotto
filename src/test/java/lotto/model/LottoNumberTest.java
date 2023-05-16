package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("로또 번호 테스트(1보다 작은 경우)")
    @ParameterizedTest
    @ValueSource(ints = {0, -1,})
    void 로또_번호_1보다_작은경우(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input))
                .withMessageMatching("로또번호는 1보다 작을 수 없습니다.");
    }


    @DisplayName("로또 번호 테스트(45보다 큰 경우)")
    @ParameterizedTest
    @ValueSource(ints = {46, 100,})
    void 로또_번호_45보다_큰경우(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input))
                .withMessageMatching("로또번호는 45보다 클 수 없습니다.");
    }

    @DisplayName("로또티켓의 번호가 당첨번호와 같은게 있는지 테스트")
    @Test
    void 당첨번호_있는지_테스트() {
        int[] ticketNumberArr = {1, 2, 3, 4, 5, 6};
        List<LottoNumber> ticketNumber = Arrays.stream(ticketNumberArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        int[] winNumberArr = {1, 2, 3, 4, 5, 45};
        List<LottoNumber> winNumber = Arrays.stream(winNumberArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        long count = ticketNumber.stream()
                .filter(lottoNumber -> lottoNumber.hasMatchNumbers(winNumber))
                .count();

        assertThat((int) count).isEqualTo(5);

    }
}
