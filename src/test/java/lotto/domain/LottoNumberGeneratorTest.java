package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("로또 번호는 6개여야 한다")
    void lotto_count() {
        Lotto numbers = LottoNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @RepeatedTest(10)
    @DisplayName("로또 번호는 중복되지 않아야 한다")
    void lotto_hash_count() {
        Lotto numbers = LottoNumberGenerator.generate();

        Set<Integer> unique = new HashSet<>(numbers.getNumbers());

        assertThat(unique).hasSize(6);
    }

    @RepeatedTest(10)
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다")
    void lotto_number() {
        Lotto lotto = LottoNumberGenerator.generate();

        assertThat(lotto.getNumbers()).allMatch(n -> n >= 1 && n <= 45);
    }
}
