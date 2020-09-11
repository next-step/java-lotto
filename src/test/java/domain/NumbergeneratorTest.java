package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumbergeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("번호 생성 테스트")
    @Test
    void generateLottoTest() {
        Set<LottoNo> numList = numberGenerator.generate();

        assertThat(numList.size()).isEqualTo(6);
    }

    @Test
    void generateTest() {

        Set<LottoNo> numList = numberGenerator.generate();

        Lotto numbers = new Lotto(numList);

        assertThat(numbers.getLottoNumber().size()).isEqualTo(6);
    }
}
