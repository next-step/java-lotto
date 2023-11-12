package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AggregatorMakerTest {

    @Test
    @DisplayName("로또 구매 금액을 통해 로또 목록을 갖는 Aggregator 클래스를 생성해줍니다.")
    void makeAggregator() {
        // given
        int lottoBuyMoney = 3000;
        AggregatorMaker aggregatorMaker = new AggregatorMaker(new TestShuffler());

        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(11, 12, 13, 14, 15, 16);
        List<Integer> third = List.of(21, 22, 23, 24, 25, 26);
        Lotto lotto1 = new Lotto(first);
        Lotto lotto2 = new Lotto(second);
        Lotto lotto3 = new Lotto(third);

        // when
        Aggregator aggregator = aggregatorMaker.makeAggregator(lottoBuyMoney);
        // then
        assertThat(aggregator).isEqualTo(new Aggregator(List.of(lotto1, lotto2, lotto3)));
    }

    @ParameterizedTest(name = "로또 구매 금액이 1000의 배수가 아니거나 1000보다 작은 값이면 IllegalArgumentException을 발생시킵니다.")
    @ValueSource(ints = {14100, 999})
    void illegalArgumentException() {
        // given
        int lottoBuyMoney = 14100;
        AggregatorMaker aggregatorMaker = new AggregatorMaker(new LottoShuffler());
        // when
        // then
        assertThatThrownBy(() -> aggregatorMaker.makeAggregator(lottoBuyMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000의 배수여야 합니다.");
    }

}