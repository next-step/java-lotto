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
        Lottos lottos = lottoStore.sell(1000L);

        assertThat(lottos.getCount()).isEqualTo(1);
    }

    @DisplayName("로또를 여러개 구입할수있다.")
    @Test
    void buy_many_lotto() {
        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.sell(5000L);

        assertThat(lottos.getCount()).isEqualTo(5);
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

    @DisplayName("로또는 6개의 숫자의 숫자를 가진다.")
    @Test
    void given_6_nums_when_lotto_create_then_success() {
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList());

        new LottoNums(lottoNumList);
    }

    @DisplayName("로또는 1부터 45까지의 수가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,-1,46})
    void given_not_1_to_45_num_when_lotto_num_create_then_throw_exception(int lottoNum){
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LottoNum(lottoNum));
    }

    @DisplayName("로또는 1부터 45까지의 수를 가지고 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,3,45})
    void given_1_to_45_num_when_lotto_num_create_then_success(int lottoNum){
        new LottoNum(lottoNum);
    }

    @DisplayName("로또가 몇게가 일치하는지 알수 있다.")
    @Test
    void match_count(){
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList());
        LottoNums lottoNums =new LottoNums(lottoNumList);
        Lotto lotto = new Lotto(lottoNums);

        assertThat(lotto.getMatchCount(lottoNums)).isEqualTo(6);
    }
}

