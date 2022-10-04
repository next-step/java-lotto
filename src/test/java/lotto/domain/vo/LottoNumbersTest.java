package lotto.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("6개 숫자들로 티켓 생성 시 정렬되어서 보관")
    void orderedLottoTicket() {
        LottoNumbers lottoNumbers = new LottoNumbers(createLottoNumberList(6, 5, 3, 4, 1, 2));
        List<LottoNumber> expected = createLottoNumberList(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.getValue()).isEqualTo(expected);
    }

    @Test
    @DisplayName("중복 숫자들로 객체 생성 시 예외 생성")
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> new LottoNumbers(createLottoNumberList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복이 없어야 합니다");
    }

    @Test
    @DisplayName("6개보다 적은 숫자로 티켓 생성 시 예외 생성")
    void createWithNotEnoughNumbers() {
        assertThatThrownBy(() -> new LottoNumbers(createLottoNumberList((1))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개여야 합니다");
    }

    private List<LottoNumber> createLottoNumberList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }
}
