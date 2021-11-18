package lotto.domain;

import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @DisplayName("match count 에 맞는 enum을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"6:1:2000000000", "5:2:1500000", "4:4:50000", "3:5:5000"}, delimiter = ':')
    void getWinningRankTest(long matchCount, int rank, BigDecimal reward) {
        WinningRank winningRank = WinningRank.valueOf(matchCount);

        assertThat(winningRank.getRank()).isEqualTo(rank);
    }

    @DisplayName("match count 가 3보다 작으면 NO_RANK를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {2l, 1l, 0l})
    void getNoRankTest(long matchCount) {
        WinningRank winningRank = WinningRank.valueOf(matchCount);

        assertThat(winningRank).isEqualTo(WinningRank.NO_RANK);
    }

    @DisplayName("No rank 를 포함한 랭크를 fifth, fourth, third, second, first 순으로 반환한다.")
    @Test
    void getWinningListTest() {
        List<WinningRank> winningRankListWithoutNoRank = WinningRank.getReverseRankListWithoutNoRank();

        List<WinningRank> expect = Arrays.asList(WinningRank.FIFTH_RANK, WinningRank.FOURTH_RANK, WinningRank.THIRD_RANK, WinningRank.SECOND_RANK, WinningRank.FIRST_RANK);
        assertThat(winningRankListWithoutNoRank).isEqualTo(expect);
    }

    @DisplayName("맞는 값이 5개인 경우 보너스볼을 기준으로 2등 3등이 나뉜다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,7:6:SECOND_RANK", "1,2,3,4,5,6:1,2,3,4,5,8:7:THIRD_RANK"}, delimiter = ':')
    void getWinningRankWithLottoTest(String lottoStr, String winningLottoStr, int bonusBallValue, String rank) {
        Lotto lotto = createLottoWithString(lottoStr);
        Lotto winningLotto = createLottoWithString(winningLottoStr);
        LottoNumber bonus = LottoNumber.create(bonusBallValue);

        WinningRank actual = WinningRank.getWinningRankWithLotto(lotto, winningLotto, bonus);
        WinningRank expect = WinningRank.valueOf(rank);

        assertThat(actual).isEqualTo(expect);
    }

    private Lotto createLottoWithString(String input) {
        return Arrays.stream(input.split(","))
                .map(LottoNumber::create)
                .collect(collectingAndThen(toList(), Lotto::create));
    }

}
