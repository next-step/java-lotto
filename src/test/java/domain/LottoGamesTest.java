package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGamesTest {
    @Test
    public void 자동_및_수동_게임_갯수_비교() {
        LottoGames lottoGames = new LottoGames();

        lottoGames.add(new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9), true));
        lottoGames.add(new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9), true));
        lottoGames.add(new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9), true));
        lottoGames.add(new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9), false));
        lottoGames.add(new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9), false));

        assertThat(lottoGames.getAutoGameCount()).isEqualTo(3);
        assertThat(lottoGames.getManualGameCount()).isEqualTo(2);
    }

    private LottoNumbers lottoNumbers(Integer... args) {
        List<LottoNumber> numbers = Arrays.stream(args)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return new LottoNumbers(numbers);
    }
}