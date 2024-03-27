package lotto.domian;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumberTest {

    @Test
    @DisplayName("초기화, 스트링 리스트를 넘겨주면 LottoNumber 리스트를 생성한다.")
    public void shouldInitializeWinnerNumberWithSixLottoNumbers() throws Exception{
        Set<Integer> numbers = Set.of(1,2,3,4,5,6);
        LottoNumber lottoNumber = LottoNumber.of(7);
        WinnerNumber winnerNumber = WinnerNumber.of(numbers, lottoNumber);
        assertThat(winnerNumber).isNotNull();
        assertThat(winnerNumber.getBonusNumber()).isEqualTo(lottoNumber);
        assertThat(winnerNumber.getWinnerNumbers()).hasSize(6);
        assertThat(winnerNumber.getWinnerNumbers()).allMatch(object -> object instanceof LottoNumber);
     }

    @Test
    @DisplayName("보너스볼이 당첨 번호와 중복되면 예외를 발생한다.")
    public void 보너스볼은_당첨_번호와_중복될_수_없다() throws Exception{
        Set<Integer> numbers = Set.of(1,2,3,4,5,6);
        LottoNumber lottoNumber = LottoNumber.of(6);
        assertThatThrownBy(()->{
            WinnerNumber.of(numbers, lottoNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외를 발생한다.")
    public void 당첨번호는_중복될_수_없다() throws Exception{
        LottoNumber bonus = LottoNumber.of(6);
        Set<Integer> numbers = Stream.of(1, 1, 2, 2, 3, 3).collect(Collectors.toSet());
        assertThatThrownBy(()->{
            WinnerNumber.of(numbers, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 중복될 수 없으며, 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호는 6개이다.")
    public void 당첨번호는_6개이다() throws Exception{
        LottoNumber bonus = LottoNumber.of(6);
        Set<Integer> numbers = Stream.of(1, 2,3,4,5).collect(Collectors.toSet());
        assertThatThrownBy(()->{
            WinnerNumber.of(numbers, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 중복될 수 없으며, 6개여야 합니다.");
    }
}
