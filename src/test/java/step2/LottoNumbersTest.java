package step2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.LottoNumbers;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또번호 생성 테스트")
    public void lottoSizeTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또번호 생성 테스트 - 랜덤한 생성")
    public void lottoNumbersTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertDoesNotThrow(
            () -> lottoNumbers.validateNumbers(lottoNumbers.getNumbers())
        );
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 중복된 숫자가 들어있을 경우")
    public void duplicatedNumberTest() {
        List<Integer> numbers = List.of(1,2,2,3,4,5);
        assertThatThrownBy(
            () -> new LottoNumbers(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 숫자가 6개 초과할 경우")
    public void exceedSizeTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(
            () -> new LottoNumbers(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 숫자가 6개 미만일 경우")
    public void underSizeTest() {
        List<Integer> numbers = List.of(1,2,3,4,5);
        assertThatThrownBy(
            () -> new LottoNumbers(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 범위 밖 숫자가 들어갔을 경우")
    public void overRangeTest() {
        List<Integer> exceedNumbers = List.of(1,2,3,4,5,46);
        List<Integer> underNumbers = List.of(0,1,2,3,4,5);
        assertAll(
            () -> assertThatThrownBy(
                () -> new LottoNumbers(exceedNumbers)
            ).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(
                () -> new LottoNumbers(underNumbers)
            ).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
