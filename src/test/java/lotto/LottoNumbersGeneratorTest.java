package lotto;

import lotto.domain.entity.Number;
import lotto.domain.generator.AutomaticLottoNumbersGenerator;
import lotto.domain.generator.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumbersGeneratorTest {

    private LottoNumbersGenerator lottoNumbersGenerator;

    @BeforeEach
    public void setup(){
        lottoNumbersGenerator = new AutomaticLottoNumbersGenerator();
    }

    @Test
    @DisplayName("로또 자동 생성기 테스트")
    public void 자동_로또_생성(){
        List<Number> numbers = lottoNumbersGenerator.generateNumber();
        assertThat(numbers.size()).isEqualTo(6);
        for (Number number : numbers) {
            assertThat(number).isBetween(Number.of(1), Number.of(45));
        }
    }

    @Test
    @DisplayName("로또 정렬 기능 테스트")
    public void 로또_정렬_확인(){
        List<Number> numbers = lottoNumbersGenerator.generateNumber();
        lottoNumbersGenerator.sortNumbers(numbers);
        Number number;
        Number nextNumber;
        for (int i = 0; i < (numbers.size() - 1) ; i++) {
            number = numbers.get(i);
            nextNumber = numbers.get(i+1);
            assertTrue(number.getNumber() < nextNumber.getNumber());
        }
    }
}
