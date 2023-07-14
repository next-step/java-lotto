package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGroupTest {
    private final List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottos.add(Lotto.createManualLotto(List.of(21, 22, 23, 24, 25, 26))); // 등수없음
    }

    @Test
    @DisplayName("구입 수량에 따라 로또 생성 테스트.")
    void createLottoGroupTest() {
        LottoGroup lottoGroup = LottoGroup.from(new Quantity(14));
        assertThat(lottoGroup.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("로또 그룹 병합 테스트.")
    void mergeGroupsTest() {
        //given
        LottoGroup group1 = LottoGroup.from(new Quantity(1));
        LottoGroup group2 = LottoGroup.from(new Quantity(2));

        //when
        LottoGroup mergedGroup = group1.merge(group2);

        //then
        assertThat(mergedGroup.getLottos()).hasSize(3);
    }
}