package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        lottos = new Lottos(lottoNumbers);
    }

    @Test
    void makeStatisticsTest() throws Exception {
        assertThat(lottos.makeStatistics(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()))).isInstanceOf(LottoResult.class);
    }
}
