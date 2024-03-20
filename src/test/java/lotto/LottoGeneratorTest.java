package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;
    @BeforeEach
    void initGenerator() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 번호 6자리 생성")
    @Test
    void lottoGenerate() {
        Lotto result = lottoGenerator.lottoGenerate();

        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 생성 범위 1~45 테스트")
    @Test
    void lottoGenerate_range() {
        List<Integer> expected = IntStream.range(1,46).boxed().collect(Collectors.toList());

        Lotto result = lottoGenerator.lottoGenerate();

        assertThat(expected).containsAll(result.getLotto());
    }

    @DisplayName("로또 번호 원자성 테스트")
    @Test
    void lottoGenerate_atomic_test() {
        Lotto result = lottoGenerator.lottoGenerate();
        Set<Integer> resultSet = result.getLotto().stream().collect(Collectors.toSet());
        assertThat(resultSet.size()).isEqualTo(result.size());
    }

    @DisplayName("로또 번호 정렬 검증")
    @Test
    void lottoGenerate_sort_test() {
        Lotto result = lottoGenerator.lottoGenerate();
        List<Integer> resultValues = result.getLotto();

        Collections.sort(resultValues);
        Lotto expected = new Lotto(resultValues);

        assertThat(result).isEqualTo(expected);
    }

}
