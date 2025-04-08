package domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.strategy.LottoNumberStrategy;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @Test
    void 정상적인_로또_묶음_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.createLottoBulk(1000 * 5); // 5장

        assertThat(lottoList).hasSize(5);
        for (Lotto lotto : lottoList) {
            assertThat(lotto.getLottoNumberList()).hasSize(6);
        }
    }

    @Test
    void 잘못된_금액_입력시_예외() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThatThrownBy(() -> lottoGenerator.createLottoBulk(1250)) // PRICE_PER_ONE으로 나누어떨어지지 않음
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입금액이 잘못되었습니다");
    }

    @Test
    void 전략_주입으로_로또_생성() {
        LottoNumberStrategy fixedStrategy = count -> Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGenerator lottoGenerator = new LottoGenerator(fixedStrategy);

        List<Lotto> lottoList = lottoGenerator.createLottoBulk(1000);

        assertThat(lottoList).hasSize(1);
        assertThat(lottoList.get(0).getLottoNumberList()).hasSize(6);
    }
}
