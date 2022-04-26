package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        List<LottoResult> lottoResultList = new ArrayList<>();
        lottoResultList.add(LottoResult.of(3));
        lottoResultList.add(LottoResult.of(3));
        lottoResultList.add(LottoResult.of(3));
        lottoResultList.add(LottoResult.of(3));
        lottoResultList.add(LottoResult.of(4));
        lottoResultList.add(LottoResult.of(4));
        lottoResultList.add(LottoResult.of(5));
        lottoResultList.add(LottoResult.of(5));
        lottoResultList.add(LottoResult.of(5));
        lottoResultList.add(LottoResult.of(6));

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

    @Test
    void 로또결과에서_5개_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(5);

        assertThat(count).isEqualTo(3);
    }

    @Test
    void 로또결과에서_6개_일치하는_개수를_찾는다() {
        int count = lottoResults.countOf(6);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void 로또구매비용에_대한_수익률을_반환한다() {
        // 요구사항의 예시
        List<LottoResult> lottoResultList = new ArrayList<>();
        lottoResultList.add(LottoResult.of(3));
        lottoResultList.add(LottoResult.of(1));
        lottoResultList.add(LottoResult.of(2));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(1));
        lottoResultList.add(LottoResult.of(2));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(1));
        lottoResultList.add(LottoResult.of(2));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(0));
        lottoResultList.add(LottoResult.of(0));

        lottoResults = new LottoResults(lottoResultList);

        double roi = lottoResults.getRoi();

        assertThat(roi).isEqualTo(0.35);
    }

}