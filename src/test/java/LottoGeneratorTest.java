import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static final int LOTTO_NUMBER = 6;

    @Test
    public void 여섯개_숫자생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createNumbers()).hasSize(LOTTO_NUMBER);
    }

    @Test
    public void 일에서사십오사이_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        lottoNumbers.forEach(number -> assertThat(number).isBetween(1, 45));
    }

    @Test
    public void 숫자_정렬() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        assertThat(lottoNumbers).containsSequence(sortedLottoNumbers);
    }

    @Test
    public void 중복없이_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(numbers.size());
    }
}