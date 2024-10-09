package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGeneratorTest {

    @Test
    public void 로또_생성_시_숫자_6개_리스트를_반환한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoBalls = lottoGenerator.generate();

        assertThat(lottoBalls).hasSize(6);
        lottoBalls.forEach(ball -> {
            assertThat(ball).isBetween(1, 45);
        });
    }
}
