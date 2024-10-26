package refactoringlotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    public static final List<Integer> TEST_WINNING_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final int EXPECTED_MATCHING_COUNT = 3;

    @Test
    public void 당첨번호일치개수_테스트() {
        List<LottoNumber> numberList = IntStream.range(4,10)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(TEST_WINNING_NUMBER_LIST);;
        assertThat(lottoWinningNumbers.lottoMatchCount(numberList)).isEqualTo(EXPECTED_MATCHING_COUNT);

    }
}
