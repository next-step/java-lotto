package lotto.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerNumberTest {

    @Test
    @DisplayName("초기화, 스트링 리스트를 넘겨주면 LottoNumber 리스트를 생성한다.")
    public void shouldInitializeWinnerNumberWithSixLottoNumbers() throws Exception{
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        WinnerNumber winnerNumber = WinnerNumber.of(numbers);
        assertThat(winnerNumber).isNotNull();
        assertThat(winnerNumber.getWinnerNumbers()).hasSize(6);
        assertThat(winnerNumber.getWinnerNumbers()).allMatch(object -> object instanceof LottoNumber);
     }

}
