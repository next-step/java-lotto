package step2.domain.lotto;

import step2.domain.LottoRequest;
import step2.domain.Rank;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static step2.LottoProvider.*;
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

        LottoRequest lottoRequest = new LottoRequest(5000, asList(new LottoNumbers(asList(2, 3, 11, 12, 22, 33))));
        lotto = new Lotto(provideLotto(lottoRequest)) {
            @Override
            List<Rank> getLottoRanks(LottoNumbers targetNumbers, LottoNumber bonusNumber) {
                return mockList.stream()
                        .map(numbers -> numbers.getRankOfLottoNumbers(targetNumbers, bonusNumber))
                        .collect(toList());
            }
        };
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void lottoTest() {
        assertThat(lotto.getLotto().size()).isEqualTo(5);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("로또 구매 실패 테스트")
    void lottoFailTest(List<LottoNumbers> lotto) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lotto))
                .withMessageContaining("로또를 구매해 주세요");
    }

    @Test
    @DisplayName("로또 당첨 순위 테스트")
    void lottoRankingTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getLottoRanks(new LottoNumbers(target), new LottoNumber(7))).containsExactly(FIRST, SECOND, THIRD, FOURTH, FIFTH, MISS);
    }

    @Test
    @DisplayName("로또 당첨 테스트")
    void winLottoTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getWinLotto(new LottoNumbers(target), new LottoNumber(7)))
                .containsKeys(FIRST, SECOND, THIRD, FOURTH, FIFTH)
                .containsValues(1L, 1L, 1L, 1L, 1L);
    }
}
