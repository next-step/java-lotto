package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottoes lottoes;
    private List<LottoGame> lottoGames;

    @BeforeEach
    void setUp() {
        lottoGames = Arrays.asList(new LottoGame(2L),
                new LottoGame(3L), new LottoGame(4L),
                new LottoGame(5L), new LottoGame(6L));
        lottoes = new Lottoes(lottoGames);
    }


    @Test
    @DisplayName("Lottoes 생성자 테스트")
    void constructor() {
        assertThat(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))))
                .isEqualTo(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))));
    }

    @Test
    @DisplayName("몇등에 당첨 됐는지 확인한다.")
    void winRankLotto() {
        assertThat(lottoes.winRankLottoCount(3L))
                .isEqualTo(1);
        assertThat(lottoes.winRankLottoCount(4L))
                .isEqualTo(1);
        assertThat(lottoes.winRankLottoCount(5L))
                .isEqualTo(1);
        assertThat(lottoes.winRankLottoCount(6L))
                .isEqualTo(1);
    }
}
