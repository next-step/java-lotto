package step4.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoRankEnumTest {
    private static LottoRankEnum LottoRankEnumTest;

    @Test
    void 로또_순위에_맞는_맞은_갯수_외_입력_테스트(){
        assertThatThrownBy(() ->
                LottoRankEnumTest = LottoRankEnum.findByRank(10)
        ).isInstanceOf(RuntimeException.class);
    }


    @Test
    void 순위1등테스트(){
        LottoRankEnumTest = LottoRankEnum.findByRank(7);
        assertThat(LottoRankEnumTest.getLottoRank()).isEqualTo(1);
    }

    @Test
    void 순위2등테스트(){
        LottoRankEnumTest = LottoRankEnum.findByRank(6);
        assertThat(LottoRankEnumTest.getLottoRank()).isEqualTo(2);
    }

    @Test
    void 순위3등테스트(){
        LottoRankEnumTest = LottoRankEnum.findByRank(5);
        assertThat(LottoRankEnumTest.getLottoRank()).isEqualTo(3);
    }

    @Test
    void 순위4등테스트(){
        LottoRankEnumTest = LottoRankEnum.findByRank(4);
        assertThat(LottoRankEnumTest.getLottoRank()).isEqualTo(4);
    }

    @Test
    void 순위5등테스트(){
        LottoRankEnumTest = LottoRankEnum.findByRank(3);
        assertThat(LottoRankEnumTest.getLottoRank()).isEqualTo(5);
    }


}
