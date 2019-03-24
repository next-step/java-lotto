package lotto.tool;

import lotto.domain.LottoBall;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {
    @Test
    public void 랜덤번호_자동생성() {
        List<LottoBall> lottoBalls = LottoAutoGenerator.random();
        for (LottoBall lottoBall : lottoBalls) {
            System.out.println(lottoBall.number);
        }
        assertThat(lottoBalls.size()).isEqualTo(6);
    }
}
