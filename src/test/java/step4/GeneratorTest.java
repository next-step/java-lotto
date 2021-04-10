package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.InputNumber;
import step2.Domain.ManualLottoGenerator;
import step2.Domain.Money;
import step2.Domain.RandomLottoNumberGenerator;
import step2.Domain.MergeGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {
    @Test
    @DisplayName("여러개의 generator들을 전달 받아 한번에 생성하는 클래스 테스트")
    void generate_test(){

        InputNumber manualNumbers = new InputNumber("1,2,3,10,20,30");
        MergeGenerator mergeGenerator =
                new MergeGenerator(Arrays.asList(new ManualLottoGenerator(Arrays.asList(manualNumbers)),
                        new RandomLottoNumberGenerator(new Money(3000))));
        assertThat(mergeGenerator.generate()).hasSize(4);
    }
}
