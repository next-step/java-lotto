package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    private LottoNumbers winnerNumbers;
    private LottoNumbers lottoNumbers;
    private final List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        numbers.addAll(Arrays.asList(1,2,3,4,5,6));
        lottoNumbers = new LottoNumbers(numbers);
    }

    @Test
    @DisplayName("LottoNumbers의 사이즈는 생성 시 주입한 List의 사이즈와 동일함을 확인한다.")
    void size() {
        assertEquals(numbers.size(), lottoNumbers.size());
    }

    @Test
    @DisplayName("LottoNumbers.sameAs 함수를 호출하면 당첨 숫자의 개수를 리턴한다.")
    void sameAs() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(2, 4, 6, 8, 10, 12));
        winnerNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.sameAs(winnerNumbers)).isEqualTo(3);

    }

    @Test
    @DisplayName("LottoNumbers의 getLottoNumbers 함수를 호출하면 List<Integer>를 리턴한다.")
    void getLottoNumbers() {
        assertEquals(lottoNumbers.getLottoNumbers(), numbers);
    }
}