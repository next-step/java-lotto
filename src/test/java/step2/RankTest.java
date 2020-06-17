package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankTest {

    @DisplayName("1등을 생성한다")
    @Test
    void create() {
        Rank first = Rank.valueOf("FIRST");
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @DisplayName("6개의 숫자가 매칭되면 1등을 생성한다")
    @Test
    void get_rank() {
        Rank rank = Rank.matches(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("1등이 호출되면 count가 1증가한다")
    @Test
    void count() {
        Rank rank = Rank.FIRST;
        assertThat(rank.getCount()).isEqualTo(1);
    }

    @DisplayName("EMPTY인지 확인하다")
    @Test
    void is_empty() {
        Rank rank = Rank.EMPTY;
        boolean empty = rank.isEmpty();
        assertThat(empty);
    }

    @DisplayName("전체 당첨금액을 구한다")
    @Test
    void total_reward() {
        Rank second = Rank.SECOND;
        int total = second.getProfit();
        assertThat(total).isEqualTo(1500000);
    }

    @DisplayName("count가 올라간 Rank의 리스트를 반환한다")
    @Test
    void get_valid_rank() {
        List<Rank> counted = Rank.getCounted();
        assertThat(counted).doesNotContain(Rank.EMPTY);
    }

    @DisplayName("Rank의 count와 reward의 곱을 반환한다")
    @Test
    void get_total_profit() {
        int sum = Rank.getTotal();
        assertThat(sum).isEqualTo(2001680000);
    }
}
