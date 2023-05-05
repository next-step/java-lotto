package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static final String SPLIT_SEPARATOR = ",";
    private static final int LOTTO_SIZE = 6;
    private static final Lotto TEST_LOTTO = Lotto.buy(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("입력한 번호만큼 로또번호가 생성되야 한다.")
    @Test
    void 로또번호갯수검증() {
        assertThat(TEST_LOTTO.hasSize(LOTTO_SIZE)).isTrue();
    }

    @ParameterizedTest(name = "입력한 로또번호에 등수결과가 matchCount 등수결과와 같아야한다.")
    @CsvSource(value = {
            "1,2,3,7,8,9|3",
            "1,2,3,4,8,9|4",
            "1,2,3,4,5,9|5",
            "1,2,3,4,5,6|6",
    }, delimiter = '|')
    void 로또결과검증(String lottoNumbers, int matchCount) {
        Lotto lotto = Lotto.buy(toList(lottoNumbers));
        assertThat(TEST_LOTTO.win(lotto)).isEqualTo(Rank.win(matchCount));
    }

    private List<Integer> toList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(SPLIT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}