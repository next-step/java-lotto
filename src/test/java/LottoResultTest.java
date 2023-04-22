import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    void 당첨_번호와_일치하는_개수를_리스트로_반환한다() {

        // given
        LottoResult lottoResult = LottoResult.makeResult();
        List<List<Integer>> numbers = asList(
                asList(1, 2, 3, 4, 5, 6),
                asList(4, 5, 6, 7, 8, 9),
                asList(4, 5, 6, 8, 11, 13),
                asList(4, 5, 6, 8, 11, 12)
        );

        List<Integer> winningNumbers = asList(4, 5, 6, 8, 11, 12);

        // when
        Map<Integer, Integer> result = lottoResult.countNumber(numbers, winningNumbers);

        // then
        assertThat(result).containsEntry(3, 1);
        assertThat(result).containsEntry(4, 1);
        assertThat(result).containsEntry(5, 1);
        assertThat(result).containsEntry(6, 1);
    }
}
