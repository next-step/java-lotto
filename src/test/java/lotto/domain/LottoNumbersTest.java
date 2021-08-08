package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;
    private final List<LottoNumber> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> numbers.add(new LottoNumber(number)));
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
        List<LottoNumber> smallSizeNumberList = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(number -> smallSizeNumberList.add(new LottoNumber(number)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(smallSizeNumberList))
                .withMessage("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + smallSizeNumberList.size());
    }

    @Test
    @DisplayName("중복된 숫자로 LottoNumbers생성 시 IllegalArgumentException이 발생한다.")
    void duplicateNumbers(){
        List<LottoNumber> duplicateNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(number -> duplicateNumbers.add(new LottoNumber(1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(duplicateNumbers));

    }

    @Test
    @DisplayName("LottoNumbers.countContains 함수를 호출하면 당첨 숫자의 개수를 리턴한다.")
    void sameAs() {
        List<LottoNumber> numbers = new ArrayList<>();
        IntStream.range(4, 10).forEach(number -> numbers.add(new LottoNumber(number)));
        assertThat(lottoNumbers.countContains(new LottoNumbers(numbers))).isEqualTo(3);

    }

    @Test
    @DisplayName("LottoNumbers의 getLottoNumbers 함수를 호출하면 List<LottoNumber>를 리턴한다.")
    void getLottoNumbers() {
        assertEquals(lottoNumbers.getLottoNumbers(), numbers);
    }
}