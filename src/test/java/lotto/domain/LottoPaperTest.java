package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @Test
    @DisplayName("생성된 로또 번호를 LottoPaper에 담는다.")
    void lottoTickets_save_test() {
        List<Lotto> lottos = new ArrayList<>();
        int expected = 6;
        for (int i = 0; i < expected; i++) {
            lottos.add(new AutoLottoGenerator().generateLotto());
        }

        LottoPaper lottoPaper = new LottoPaper(lottos);

        assertThat(lottoPaper.getLottos().size()).isEqualTo(expected);
    }
}
