package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    private List<LottoNumber> numberList;

    @BeforeEach
    void setUp() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        LottoNumbers numbers = lottoAutoGenerator.generateNumbers();
        numberList = numbers.get();
    }

    @DisplayName("자동 생성 유효성 검사 (개수 일치 여부)")
    @Test
    void checkValidRandomNumbers() {
        assertThat(numberList.size())
            .isEqualTo(LottoGenerator.LOTTO_NUMBERS);
    }
}
