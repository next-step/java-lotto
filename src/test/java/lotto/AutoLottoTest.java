package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTest {
    private LottoNumGenerator lottoNumGenerator;
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumGenerator = new AutoLottoNumGenerator();
        lottoNumbers = lottoNumGenerator.generate();

    }

    @Test
    @DisplayName("자동번호 추출이 1~45 범위에 있는지 테스트")
    void testBetweenOneAnd45thLottoNum() {
        List<Integer> a = IntStream.rangeClosed(LottoNumGenerator.MAX_INT, LottoNumGenerator.MAX_INT)
                .boxed().collect(Collectors.toList());
        assertThat(lottoNumbers).containsAnyElementsOf(a);
    }

    @Test
    @DisplayName("자동번호 길이가 6인지")
    void testIsLength6LottoNum() {
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("자동번호 추출이 서로 중복되지 않는지 테스트")
    void testIsNotDuplicatedLottoNum() {
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(lottoNumbers.size());
    }
}

