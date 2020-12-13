package lotto.domain.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = new WinningLottoNumbers("1, 2, 3, 4, 5, 6");
    }

    @DisplayName("입력받은 당첨 번호를 쪼개서 리스트 형식으로 만든다.")
    @Test
    void create_WinningLottoNumbers() {
        List<LottoNumber> expectedList = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThat(winningLottoNumbers.getLottoNumbers()).isEqualTo(expectedList);
    }

    @DisplayName("번호가 당첨번호 리스트에 포함되어 있으면 true 반환.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6})
    void isContain(int number) {
        boolean result = winningLottoNumbers.isContain(new LottoNumber(number));
        assertThat(result).isTrue();
    }
}
