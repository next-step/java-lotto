package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new RandomLottoGenerator();
    }

    @DisplayName("랜덤 로또 생성 테스트 : 로또를 이루는 숫자는 6개")
    @Test
    void case1() {
        Set<LottoNumber> result = lottoGenerator.create();
        assertThat(result).hasSize(6);
    }
}
