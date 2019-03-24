package lotto.tool;

import lotto.domain.LottoBall;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoShufflerTest {

    @Test
    public void 주어진_숫자_리스트_섞기() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i + 1));
        }
        LottoShuffler.shuffle(lottoBalls);

        for (LottoBall lottoBall : lottoBalls) {
            System.out.println(lottoBall.number);
        }
    }
}
