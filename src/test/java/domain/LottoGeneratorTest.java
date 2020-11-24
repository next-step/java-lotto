package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void generateTest_자동() throws Exception {
        assertThat(LottoGenerator.generate(5).size()).isEqualTo(5);
    }

    @Test
    void generateTest_수동() throws Exception {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6));
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6));
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6));

        assertThat(LottoGenerator.generate(3).size()).isEqualTo(3);
    }
}
