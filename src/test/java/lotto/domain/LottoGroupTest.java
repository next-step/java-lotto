package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    private LottoGroup lottoGroup;

    @BeforeEach
    public void setup() {
        lottoGroup = new LottoGroup(new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 7, 8),
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(1, 2, 7, 8, 9, 10));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void createLottoGroup(int countOfLotto) {
        LottoGroup lottoGroup = new LottoGroup(countOfLotto);
        assertThat(lottoGroup.getLottos()).hasSize(countOfLotto);
    }

    @Test
    public void of() {
        assertThat(lottoGroup).isEqualTo(new LottoGroup(new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 7, 8),
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void matching() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        List<Rank> matchingResult = lottoGroup.matching(winningLotto, bonusNo);
        assertThat(matchingResult).hasSize(6).containsExactly(Rank.values());
    }
}
