package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.execute;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("입력 받은 수의 로또를 발급한다")
    void 입력_받은_수의_로또를_발급한다() {
        int buyCount = 5;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            List<Integer> lottoTicket = execute();
            result.add(lottoTicket);
        }

        assertThat(result.size()).isEqualTo(5);
    }
}
