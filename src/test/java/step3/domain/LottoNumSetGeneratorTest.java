package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumSetGeneratorTest {

    @Test
    void 로또_생성기는_랜덤으로_로또숫자집합을_생성함() {
        LottoNumSet lottoNumSet = LottoNumSetGenerator.generateRandomSet();

        assertThat(lottoNumSet.getLottoNumSet().size()).isEqualTo(LottoNumSet.LOTTO_NUM_COUNT);
        assertThat(lottoNumSet.getLottoNumSet())
                .allMatch(lottoNum ->
                        lottoNum.getLottoNum() >= LottoNum.MIN_LOTTO_NUM &&
                        lottoNum.getLottoNum() <= LottoNum.MAX_LOTTO_NUM);
    }

    @Test
    void 로또_생성기는_문자열을_받아서_로또숫자집합을_생성함() {
        LottoNumSet lottoNumSet = LottoNumSetGenerator.generateSet("1,2,3,4,5,6");

        assertThat(lottoNumSet).isEqualTo(new LottoNumSet(List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        )));
    }
}
