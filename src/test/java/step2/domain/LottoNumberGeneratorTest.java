package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호는 항상 6개를 생성한다")
    void generate_returnsSixNumbers() {
        LottoNumbers lotto = LottoNumberGenerator.generate();

        assertThat(lotto.numbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또 번호는 중복이 없어야 한다")
    void generate_noDuplicates() {
        LottoNumbers lotto = LottoNumberGenerator.generate();

        Set<Integer> unique = lotto.numbers().stream()
                .map(n -> n.getNumber())
                .collect(Collectors.toSet());

        assertThat(unique).hasSize(6);
    }

    @RepeatedTest(5)
    @DisplayName("여러 번 실행해도 로또 번호가 매번 섞여 나온다")
    void generate_returnsShuffledNumbers() {
        LottoNumbers first = LottoNumberGenerator.generate();
        LottoNumbers second = LottoNumberGenerator.generate();

        List<Integer> firstList = first.numbers()
                .stream()
                .map(n -> n.getNumber())
                .collect(Collectors.toList());
        List<Integer> secondList = second.numbers()
                .stream()
                .map(n -> n.getNumber())
                .collect(Collectors.toList());

        assertThat(firstList).isNotEqualTo(secondList);
    }
}
