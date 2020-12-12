package step2.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoNumberTest {

    @Test
    @DisplayName(value = "WinningLottoNumber 생성 테스트")
    void create() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,45);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);

        assertThat(winningLottoNumber.getNumbers().size()).isEqualTo(6);

        List<Integer> collect = winningLottoNumber.getNumbers()
                .stream()
                .map(lottoNo -> lottoNo.getNumber())
                .collect(Collectors.toList());

        assertThat(collect).containsAll(list);
    }

    @Test
    @DisplayName(value = "우승번호와 구입한 로또를 비교하여 맞는 개수를 찾음.")
    void findIsMatchNumberCount() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,45);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(winningNumber);

        assertThat(winningLottoNumber.findIsMatchNumberCount(Lotto.create(Arrays.asList(5,6,7,8,9,10)))).isEqualTo(1);
        assertThat(winningLottoNumber.findIsMatchNumberCount(Lotto.create(Arrays.asList(1,2,3,4,5,45)))).isEqualTo(6);
    }


    @Test
    @DisplayName("당첨번호와 겹치는 보너스 숫자를 입력하면 Exception을 발생시킴.")
    void addBonusNumber_isNotContainsWinningNumber_ShouldException() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,10);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);

        assertThatThrownBy(() -> winningLottoNumber.addBonusNumber(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
