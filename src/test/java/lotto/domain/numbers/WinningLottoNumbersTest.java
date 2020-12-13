package lotto.domain.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {

    @DisplayName("입력받은 당첨 번호를 쪼개서 리스트 형식으로 만든다.")
    @Test
    void create_WinningLottoNumbers() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1, 2, 3, 4, 5, 6");
        List<LottoNumber> expectedList = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        assertThat(winningLottoNumbers.getLottoNumbers()).isEqualTo(expectedList);
    }
}
