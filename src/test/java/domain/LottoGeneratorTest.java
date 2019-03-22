package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    private final static int LOTTO_MAX_NUMBER = 46;
    private LottoGenerator lottoGenerator;

    @Before
    public void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    public void 생성된_랜덤숫자중_46을_초과하는_값이_있는지() {
        List<Integer> randomNumbers = lottoGenerator.generateRandomNumber();
        Collections.sort(randomNumbers);
        int maximumNumber = randomNumbers.get(randomNumbers.size()-1);
        assertThat(maximumNumber).isLessThanOrEqualTo(LOTTO_MAX_NUMBER);
    }
}
