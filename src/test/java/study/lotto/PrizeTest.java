package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.model.Lotto;
import study.lotto.model.LottoNumber;
import study.lotto.model.LottoRank;
import study.lotto.model.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("로또 당첨금 계산")
    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5, 6", "2, 3, 4, 7, 9, 12" })
    void check_prize(String input) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::new).collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);

        String[] split = input.split(", ");
        WinningLotto winningLotto = WinningLotto.of(split);

        LottoRank lottoRank = lotto.getPrize(winningLotto);

        assertThat(lottoRank.getPrize())
                .isEqualTo(5000);
    }
}
