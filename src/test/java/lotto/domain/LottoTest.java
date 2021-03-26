package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"7,8,9,10,11,12:0", "1,8,9,10,11,12:0", "1,2,9,10,11,12:0",
                        "1,2,3,10,11,12:3",
                        "1,2,3,4,11,12:4",
                        "1,2,3,4,5,12:5",
                        "1,2,3,4,5,6:6"}
                        , delimiter = ':')
    @DisplayName("로또 등수계산")
    void lotto_inquiryRank(String winNumbers, int matchCount) {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoRank lottoRank = lotto.inquiryRank(Arrays.stream(winNumbers.split(",")).mapToInt(Integer::valueOf).toArray());

        // then
        assertThat(LottoRank.getEnum(matchCount)).isEqualTo(lottoRank);
    }

}