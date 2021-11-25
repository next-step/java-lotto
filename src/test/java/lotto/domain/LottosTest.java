package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("Lottoes 생성자 테스트")
    public void constructor() {
        assertThat(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))))
                .isEqualTo(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))));
    }

    @Test
    @DisplayName("몇등에 당첨 됐는지 확인한다.")
    public void winRankLotto() {
        List<LottoGame> lottoGames = Arrays.asList(new LottoGame(2L),
                new LottoGame(3L), new LottoGame(4L),
                new LottoGame(3L), new LottoGame(4L),
                new LottoGame(5L), new LottoGame(6L));
        Lottoes lottoes = new Lottoes(lottoGames);

        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 3)
                .count())
                .isEqualTo(2);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 4)
                .count())
                .isEqualTo(2);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 5)
                .count())
                .isEqualTo(1);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 6)
                .count())
                .isEqualTo(1);
    }

}
