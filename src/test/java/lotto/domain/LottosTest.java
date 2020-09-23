package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottos = Lottos.of(0, Arrays.asList(
                "1,2,3,4,5,6",
                "9,10,11,12,13,14"));
        winningLotto = WinningLotto.of(Arrays.asList(4,5,6,7,8,9), 19);
    }

    @DisplayName("로또 개수에 따라 로또 발급 테스트")
    @Test
    void createLottos() {
        List<String> manualLottoNumbers = Stream.of(
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44")
                .collect(Collectors.toList());
        Lottos lottos = Lottos.of(3, manualLottoNumbers);
        assertThat(lottos.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 당첨 로또 번호와 매칭 확인 테스트")
    @Test
    void match() {
        LottoResult lottoResult = lottos.match(winningLotto);
        assertThat(lottoResult.totalPrizeOfMathRanks()).isEqualTo(5000);
        assertThat(lottoResult.countOfMathRanks(Rank.FIFTH)).isEqualTo(1);
    }
}
