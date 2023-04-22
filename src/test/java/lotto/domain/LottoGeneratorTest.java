package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또(1~45 사이의 숫자 6개, 중복없음)를 생성합니다.")
    void test01() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lotto = lottoGenerator.generate();
        assertThat(lotto).hasSize(new HashSet<>(lotto).size());
    }

}