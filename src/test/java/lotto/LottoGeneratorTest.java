package lotto;

import lotto.domain.entity.Number;
import lotto.domain.generator.AutomaticLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    public void setup(){
        lottoGenerator = new AutomaticLottoGenerator();
    }

    @Test
    @DisplayName("로또 자동 생성기 테스트")
    public void 자동_로또_생성(){
        List<Number> numbers = lottoGenerator.numberGenerator();
        assertThat(numbers.size()).isEqualTo(6);
        for (Number number : numbers) {
            assertThat(number).isBetween(new Number(1), new Number(45));
        }
    }

    @Test
    @DisplayName("로또 정렬 기능 테스트")
    public void 로또_정렬_확인(){
        List<Number> numbers = lottoGenerator.numberGenerator();
        lottoGenerator.sortNumbers(numbers);
        Number number;
        Number nextNumber;
        for (int i = 0; i < (numbers.size() - 1) ; i++) {
            number = numbers.get(i);
            nextNumber = numbers.get(i+1);
            assertTrue(number.getNumber() < nextNumber.getNumber());
        }
    }
}
