package lotto.service;

import lotto.entity.Lotto;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {
    private final LottoResultChecker resultChecker = new LottoResultChecker();

    @Test
    @DisplayName("1등-6개일치")
    void check1() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                8);
        assertThat(result.getCountByLottoRank())
                .containsEntry(LottoRank.FIRST, 1);
    }

    @Test
    @DisplayName("2등-5개 일치 및 보너스볼 일치")
    void check2() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(7, 5, 4, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7);
        assertThat(result.getCountByLottoRank())
                .containsEntry(LottoRank.SECOND, 1);
    }

    @Test
    @DisplayName("3등-5개 일치 및 보너스볼 불일치")
    void check3() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(7, 5, 4, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                6);
        assertThat(result.getCountByLottoRank())
                .containsEntry(LottoRank.THIRD, 1);
    }

    @Test
    @DisplayName("4등-4개 일치")
    void check4() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(9, 8, 4, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                6);
        assertThat(result.getCountByLottoRank())
                .containsEntry(LottoRank.FOURTH, 1);
    }

    @Test
    @DisplayName("5등-3개 일치")
    void check5() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(12, 11, 10, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                6);
        assertThat(result.getCountByLottoRank())
                .containsEntry(LottoRank.FIFTH, 1);
    }

    @Test
    @DisplayName("당첨대상 없음")
    void check6() {
        var result = resultChecker.checkResult(
                List.of(
                        new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(13, 14, 15, 16, 17, 18))),
                new Lotto(List.of(19, 20, 21, 22, 23, 24)),
                6);
        assertThat(result.getCountByLottoRank())
                .doesNotContainKeys(
                        LottoRank.FIRST, LottoRank.SECOND,
                        LottoRank.THIRD, LottoRank.FOURTH,
                        LottoRank.FIFTH
                );
    }
}