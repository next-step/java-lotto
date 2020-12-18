package step2.domain.lotto;

import step2.domain.Rank;
import step2.domain.Request;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static step2.LottoNumberGenerator.*;
import static step2.domain.Rank.*;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoNumbers> mockList = new ArrayList<>();
        mockList.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 45))); // 6개 일치
        mockList.add(new LottoNumbers(asList(1, 7, 10, 20, 30, 40))); // 5개 일치 + 보너스 일치
        mockList.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 41))); // 5개 일치
        mockList.add(new LottoNumbers(asList(1, 10, 20, 30, 39, 41))); // 4개 일치
        mockList.add(new LottoNumbers(asList(1, 10, 20, 33, 39, 41))); // 3개 일치
        mockList.add(new LottoNumbers(asList(1, 10, 22, 33, 39, 41))); // 2개 일치

        lotto = new Lotto(new Request(5000)) {
            @Override
            List<Rank> getLottoRanks(List<Integer> targetNumbers, Integer bonusNumber) {
                return mockList.stream()
                        .map(numbers -> Rank.getRank(numbers.getEqualNumberCount(targetNumbers, bonusNumber)))
                        .collect(toList());
            }
        };
    }

    @Test
    @DisplayName("로또(자동) 구매 테스트")
    void buyLottoTest() {
        assertThat(lotto.getLotto().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 당첨 순위 테스트")
    void lottoRankingTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getLottoRanks(target, 7)).containsExactly(FIRST, SECOND, THIRD, FOURTH, FIFTH, MISS);
    }

    @Test
    @DisplayName("로또 당첨 테스트")
    void winLottoTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getWinLotto(target, 7))
                .containsKeys(FIRST, SECOND, THIRD, FOURTH, FIFTH)
                .containsValues(asList(FIRST), asList(SECOND), asList(THIRD), asList(FOURTH), asList(FIFTH));
    }

    @Test
    @DisplayName("로또 번호 제공 테스트")
    void lottoNumberTest() {
        assertThat(provideLottoNumbers().size()).isEqualTo(6);
    }
}
