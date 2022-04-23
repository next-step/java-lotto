package lotto.domain;

import static lotto.domain.LottoResult.REWARD_FIRST_GRADE;
import static lotto.domain.LottoResult.REWARD_FOURTH_GRADE;
import static lotto.domain.LottoResult.REWARD_NONE_GRADE;
import static lotto.domain.LottoResult.REWARD_SECOND_GRADE;
import static lotto.domain.LottoResult.REWARD_THIRD_GRADE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @Test
    void createLottoResultTest() {
        int fitCount = 1;
        lottoResult = LottoResult.of(fitCount);

        assertThat(lottoResult).isNotNull();
    }

    @DisplayName("맞춘 개수에 맞는 로또 결과 객체가 나왔는지 확인한다.")
    @Test
    void lottoResultGradeTest() {
        int fitCount0 = 0;
        int fitCount3 = 3;
        int fitCount4 = 4;
        int fitCount5 = 5;
        int fitCount6 = 6;

        LottoResult lottoResult0 = LottoResult.of(fitCount0);
        LottoResult lottoResult1 = LottoResult.of(fitCount0);
        LottoResult lottoResult2 = LottoResult.of(fitCount0);
        LottoResult lottoResult3 = LottoResult.of(fitCount3);
        LottoResult lottoResult4 = LottoResult.of(fitCount4);
        LottoResult lottoResult5 = LottoResult.of(fitCount5);
        LottoResult lottoResult6 = LottoResult.of(fitCount6);

        assertThat(lottoResult0.fitCount()).isEqualTo(fitCount0);
        assertThat(lottoResult0.reward()).isEqualTo(REWARD_NONE_GRADE);
        assertThat(lottoResult1.fitCount()).isEqualTo(fitCount0);
        assertThat(lottoResult1.reward()).isEqualTo(REWARD_NONE_GRADE);
        assertThat(lottoResult2.fitCount()).isEqualTo(fitCount0);
        assertThat(lottoResult2.reward()).isEqualTo(REWARD_NONE_GRADE);
        assertThat(lottoResult3.fitCount()).isEqualTo(fitCount3);
        assertThat(lottoResult3.reward()).isEqualTo(REWARD_FOURTH_GRADE);
        assertThat(lottoResult4.fitCount()).isEqualTo(fitCount4);
        assertThat(lottoResult4.reward()).isEqualTo(REWARD_THIRD_GRADE);
        assertThat(lottoResult5.fitCount()).isEqualTo(fitCount5);
        assertThat(lottoResult5.reward()).isEqualTo(REWARD_SECOND_GRADE);
        assertThat(lottoResult6.fitCount()).isEqualTo(fitCount6);
        assertThat(lottoResult6.reward()).isEqualTo(REWARD_FIRST_GRADE);
    }

}