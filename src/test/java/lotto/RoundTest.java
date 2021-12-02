package lotto;

import lotto.game.Rank;
import lotto.game.Round;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    List<LottoNumber> lottoNumbers = LottoNumber.toLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void create() {
        Round round = new Round(3, () -> lottoNumbers);
        assertThat(round.gameCount()).isEqualTo(3);

        round.getGames().forEach(game -> {
            Rank result = game.win(lottoNumbers);
            assertThat(result).isEqualTo(Rank.FIRST_WIN);
        });
    }

    @Test
    void result() {
        Round round = new Round(3, () -> lottoNumbers);
        EnumMap<Rank, Integer> result = round.getResult(lottoNumbers);
        assertThat(result.get(Rank.FIRST_WIN)).isEqualTo(3);
    }

    @Test
    void totalAward() {
        Round round = new Round(3, () -> lottoNumbers);
        long totalAward = round.totalAward(lottoNumbers);
        assertThat(totalAward).isEqualTo(2000000000L * 3);
    }
}
