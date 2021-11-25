package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    @DisplayName("LottoNumbers 생성자 테스트")
    public void constructor() {
        assertThat(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())))
                .isEqualTo(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())));
    }

    @Test
    @DisplayName("자동으로 로또번호를 생성한다.")
    public void createAutoLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.createAutoLottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("지난 주 당첨 번호는 6개만 입력 받는다.")
    public void validateLottoNumbersLength() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> {
            lottoNumbers.validateLottoNumbersLength();
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("지난 주 당첨 번호는 6개만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("지난 주 당첨 번호는 1~45의 값을 가진다.")
    public void validateLottoNumbersOneToFortyfive() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 46));

        assertThatThrownBy(() -> {
            lottoNumbers.validateLottoNumbersOneToFortyfive();
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("지난 주 당첨 번호는 1~45만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("지난 주 당첨 번호를 콤마로 이어준다.")
    public void getLottoNumbersJoinComma() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 45));
        assertThat(lottoNumbers.getLottoNumbers().stream()
                .map(number -> number.toString())
                .collect(Collectors.joining(", ")))
                .isEqualTo("1, 2, 3, 4, 5, 45");
    }
}
