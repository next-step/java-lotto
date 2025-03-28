package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또번호는_6개의_숫자이며_중복되지않는다() {
        List<LottoNum> numbers = LottoGenerator.generate();

        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }


    @Test
    void 로또번호는_1부터_45까지의_숫자이다() {
        List<LottoNum> numbers = LottoGenerator.generate();

        assertThat(numbers.stream().allMatch(number -> number.num() >= 1 && number.num() <= 45)).isTrue();
    }
}
