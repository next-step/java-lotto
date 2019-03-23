import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static final int LOTTO_SIZE = 6;

    @Test
    public void 중복없이_여섯개_생성() {
        Set<LottoNumber> numbers = new HashSet<>(LottoGenerator.createLotto());
        assertThat(numbers).isNotNull().hasSize(LOTTO_SIZE);
    }

    @Test
    public void 숫자_정렬() {
        List<LottoNumber> lottoNumbers = LottoGenerator.createLotto();
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        assertThat(lottoNumbers).containsSequence(sortedLottoNumbers);
    }
}