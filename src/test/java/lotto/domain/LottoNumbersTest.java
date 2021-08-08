package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    private LottoNumbers winnerNumbers;
    private LottoNumbers lottoNumbers;
    private final List<LottoNumber> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        IntStream.range(1, 7).forEach(number -> numbers.add(new LottoNumber(number)));
        lottoNumbers = new LottoNumbers(numbers);
    }

    @Test
    @DisplayName("LottoNumbers의 사이즈는 생성 시 주입한 List의 사이즈와 동일함을 확인한다.")
    void size() {
        assertEquals(numbers.size(), lottoNumbers.size());
    }

    @Test
    @DisplayName("LottoNumbers 생성 시 리스트의 사이즈가 6이 아니면 IllegalArgumentException이 발생한다")
    void sizeException() {
        List<LottoNumber> numbers = new ArrayList<>();
        IntStream.range(1, 6).forEach(number -> numbers.add(new LottoNumber(number)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(numbers))
                .withMessage("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + numbers.size());
    }

    @Test
    @DisplayName("LottoNumbers.sameAs 함수를 호출하면 당첨 숫자의 개수를 리턴한다.")
    void sameAs() {
        List<LottoNumber> numbers = new ArrayList<>();
        IntStream.range(4, 10).forEach(number -> numbers.add(new LottoNumber(number)));
        winnerNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.sameAs(winnerNumbers)).isEqualTo(3);
    }

    @Test
    @DisplayName("LottoNumbers의 getLottoNumbers 함수를 호출하면 List<Integer>를 리턴한다.")
    void getLottoNumbers() {
        assertEquals(lottoNumbers.getLottoNumbers(), numbers);
    }
}