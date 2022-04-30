package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        List<LottoResult> lottoResultList = new ArrayList<>();
        lottoResultList.add(LottoResult.of(3, false));
        lottoResultList.add(LottoResult.of(3, true));
        lottoResultList.add(LottoResult.of(3, false));
        lottoResultList.add(LottoResult.of(3, true));
        lottoResultList.add(LottoResult.of(4, false));
        lottoResultList.add(LottoResult.of(4, true));
        lottoResultList.add(LottoResult.of(5, false));
        lottoResultList.add(LottoResult.of(5, false));
        lottoResultList.add(LottoResult.of(5, true));
        lottoResultList.add(LottoResult.of(6, true));

        lottoResults = new LottoResults(lottoResultList);
    }

    @Test
    void 로또결과에서_3개_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(3);

        assertThat(count).isEqualTo(4);
    }

    @Test
    void 로또결과에서_4개_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(4);

        assertThat(count).isEqualTo(2);
    }

    @DisplayName("5개 일치하면서 보너스번호가 일치하지 않는 경우가 있다.")
    @Test
    void 로또결과에서_5개만_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(5);

        assertThat(count).isEqualTo(3);
    }

    @DisplayName("5개 일치하면서 보너스번호가 일치하지 않는 경우가 있다.")
    @Test
    void 로또결과에서_5개와_보너스번호가_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(5);

        assertThat(count).isEqualTo(3);
    }

    @Test
    void 로또결과에서_6개_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(6);

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("로또 구매비용 대비 수익률을 확인한다. (요구사항의 예시)")
    @Test
    void 로또구매비용에_대한_수익률을_반환한다() {
        // 요구사항의 예시
        List<LottoResult> lottoResultList = new ArrayList<>();
        lottoResultList.add(LottoResult.of(3, false));
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(0, false));

        lottoResults = new LottoResults(lottoResultList);

        assertThat(lottoResults.getRoi()).isEqualTo(0.35);
    }

    @DisplayName("로또 구매비용 대비 수익률을 확인한다. (1, 2, 3등 포함)")
    @Test
    void 로또구매비용에_대한_수익률을_반환한다_2() {
        // 요구사항의 예시
        List<LottoResult> lottoResultList = new ArrayList<>(); // 총 14000 원 구매

        lottoResultList.add(LottoResult.of(3, false)); // 5000
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(1, false));
        lottoResultList.add(LottoResult.of(2, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(0, false));
        lottoResultList.add(LottoResult.of(5, false)); // 1500000
        lottoResultList.add(LottoResult.of(5, true));  // 30000000
        lottoResultList.add(LottoResult.of(6, false)); // 2000000000

        lottoResults = new LottoResults(lottoResultList);

        assertThat(lottoResults.getRoi()).isEqualTo(145107.5);
    }

}