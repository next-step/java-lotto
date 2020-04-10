package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    private LottoGroup lottoGroup;

    @BeforeEach
    public void setup() {
        lottoGroup = new LottoGroup(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 8)),
                Lotto.of(Arrays.asList(1, 2, 3, 4, 7, 8)),
                Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
                Lotto.of(Arrays.asList(1, 2, 7, 8, 9, 10)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void buyAutoSelectLotto(int countOfLotto) {
        LottoGroup lottoGroup = LottoGroup.buyAutoSelectLotto(countOfLotto);
        assertThat(lottoGroup.getLottos()).hasSize(countOfLotto);
    }

    @Test
    public void matching() {
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNo = 7;
        List<Rank> matchingResult = lottoGroup.matching(winningLotto, bonusNo);
        assertThat(matchingResult).hasSize(6).containsExactly(Rank.values());
    }
}
