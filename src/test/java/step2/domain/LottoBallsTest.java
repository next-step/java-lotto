package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {

    @Test
    public void 로또번호를_생성한다() {
        LottoBalls lottoBalls = new LottoBalls();
        List<Integer> lottoNumbers = lottoBalls.getLottoBalls(6);

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45);
    }

    @Test
    public void 로또번호의_중복이_없어야_한다() {
        LottoBalls lottoBalls = new LottoBalls();
        List<Integer> lottoNumbers = lottoBalls.getLottoBalls(6);

        assertThat(lottoNumbers).hasSize((int) lottoNumbers.stream().distinct().count());
    }
}
