package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    public static final List<Integer> TEST_WINNING_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final List<Integer> TEST_WRONG_RANGE_LIST = List.of(1, 2, 3, 4, 5);
    public static final int EXPECTED_RANK = 4;

    @Test
    public void 당첨번호일치개수별랭크_테스트() {
        List<LottoNumber> numberList = IntStream.range(4, 10)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lottoWinningNumbers = new LottoNumbers(TEST_WINNING_NUMBER_LIST);
        assertThat(lottoWinningNumbers.lottoRank(numberList)).isEqualTo(EXPECTED_RANK);
    }

    @Test
    public void 개수_6개_불일치_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers lottoWinningNumbers = new LottoNumbers(TEST_WRONG_RANGE_LIST);
        });
    }

}
