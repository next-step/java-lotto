package lotto.domain;

import lotto.LottoRankEnum;
import lotto.exception.InvalidLottoRankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoRankEnumTest {

    @DisplayName("로또를 몇개 맞았는지 수로 RankEnum 이 일치하는지 테스트")
    @Test
    void rankEnumTest() {
        LottoRankEnum lottoRankEnum = LottoRankEnum.valueOf(3);

        assertThat(lottoRankEnum).isEqualTo(LottoRankEnum.THREE_MATCH);
    }

    @DisplayName("Rank 에 없는 로또를 몇개 맞았는지 수를 입력 했을 때 Exception 테스트")
    @Test
    void invalidLottoRankExceptionTest() {
        assertThatExceptionOfType(InvalidLottoRankException.class)
                .isThrownBy(() -> {
                    LottoRankEnum lottoRankEnum = LottoRankEnum.valueOf(2);
                }).withMessageMatching("올바르지 않은 RANK 입니다.");
    }
}
