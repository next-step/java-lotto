package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void buy_one_lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(1000L);

        assertThat(lottos).hasSize(1);
    }

    @Test
    void buy_many_lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(5000L);

        assertThat(lottos).hasSize(5);
    }

    @DisplayName("로또는 6개의 숫자를 가지고 있다.")
    @Test
    void when_lotto_create_then_lotto_has_6_nums() {
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList());

        LottoNums lottoNums = new LottoNums(lottoNumList);
        Lotto lotto = new Lotto(lottoNums);
    }




}
