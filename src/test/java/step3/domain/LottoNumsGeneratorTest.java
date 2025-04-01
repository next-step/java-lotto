package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumsGeneratorTest {

    @Test
    void 로또_생성기는_랜덤으로_로또숫자집합을_생성함() {
        LottoNums lottoNums = LottoNumSetGenerator.generateRandomSet();

        assertThat(lottoNums.getLottoNums().size()).isEqualTo(LottoNums.LOTTO_NUM_COUNT);
        assertThat(lottoNums.getLottoNums())
                .allMatch(lottoNum ->
                        lottoNum.getLottoNum() >= LottoNum.MIN_LOTTO_NUM &&
                        lottoNum.getLottoNum() <= LottoNum.MAX_LOTTO_NUM);
    }

    @Test
    void 로또_생성기는_문자열을_받아서_로또숫자집합을_생성함() {
        LottoNums lottoNums = LottoNumSetGenerator.generateSet("1,2,3,4,5,6");

        assertThat(lottoNums).isEqualTo(new LottoNums(List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        )));
    }
}
