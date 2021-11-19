package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("랜덤 로또번호 생성 - 6자리, 1~45, 중복값 x")
    void autoCreate() {
        Lotto lotto = LottoGenerator.createLotto();
        List<Integer> numbers =  lotto.getNumbers();
        assertThat(numbers).size().isEqualTo(6);
        assertThat(numbers).doesNotContain(0);
        assertThat(numbers).doesNotContain(46);
        assertThat(numbers.stream().allMatch(n -> n >= 1 && n <= 45)).isTrue();
    }

}