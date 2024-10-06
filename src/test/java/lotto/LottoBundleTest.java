package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test
    void 개수만큼_로또_생성() {
        LottoBundle lottoBundle = LottoBundle.of(5);

        assertThat(lottoBundle.count()).isEqualTo(5);
    }
}
