package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoRank;
import study.lotto.domain.WinningLottoInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("로또 당첨금 계산")
    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5, 6", "2, 3, 4, 7, 9, 12" })
    void check_prize(String input) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);

        String[] split = input.split(", ");
        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(split, 13);

        LottoRank lottoRank = winningLottoInfo.checkLottoRank(lotto);

        assertThat(lottoRank.getPrize())
                .isEqualTo(5000);
    }

    @DisplayName("로또 당첨금 계산 - 2등")
    @Test
    void check_prize_should_return_second_prize() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);

        String[] split = "1, 3, 5, 7, 10, 12".split(", ");
        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(split, 9);

        LottoRank lottoRank = winningLottoInfo.checkLottoRank(lotto);

        assertThat(lottoRank)
                .isEqualTo(LottoRank.SECOND_RANK);
    }
}
