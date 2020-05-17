package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @DisplayName("로또를 한개 구입할수있다.")
    @Test
    void buy_one_lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(1000L);

        assertThat(lottos).hasSize(1);
    }

    @DisplayName("로또를 여러개 구입할수있다.")
    @Test
    void buy_many_lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(5000L);

        assertThat(lottos).hasSize(5);
    }

    @DisplayName("로또는 6개의 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,7,10})
    void given_not_6_when_lotto_create_then_throw_exception(int numCount) {
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(numCount).collect(
            Collectors.toList());

        assertThatThrownBy(()->new LottoNums(lottoNumList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개의 숫자의 숫자를 가진다..")
    @DisplayName("로또는 6개의 숫자의 숫자를 가진다.")
    @Test
    void given_6_nums_when_lotto_create_then_success() {
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList());

        new LottoNums(lottoNumList);
    }


}
