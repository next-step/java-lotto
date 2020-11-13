package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    private LottoCalculator lottoCalculator;
    private List<List<Integer>> lottoNumbers;

    @BeforeEach
    void setUp(){
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        lottoNumbers.add(Arrays.stream(new int[]{4, 5, 6, 7, 8, 9}).boxed().collect(Collectors.toList()));
        lottoCalculator = new LottoCalculator(lottoNumbers);
    }

    @Test
    void calculateTest() throws Exception {
        List<Integer> winningNumbers = Arrays.stream(new int[]{4,5,6,11,12,13}).boxed().collect(Collectors.toList());
        LottoResult lottoResult = lottoCalculator.calculate(winningNumbers);
        assertThat(lottoResult.getFourthPrize()).isEqualTo(2);
    }

}
