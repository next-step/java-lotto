package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSetTest {
    @Test
    public void 초기화_여부를_체크한다() {
        NumberSet numberSet1 = NumberSet.empty();
        assertThat(numberSet1.isEmpty()).isTrue();

        NumberSet numberSet2 = NumberSet.fill(1,2,3,4,5,6);
        assertThat(numberSet2.isEmpty()).isFalse();
    }

    @Test
    public void 비어있는_2개의_NumberSet은_같다() {
        assertThat(NumberSet.empty()).isEqualTo(NumberSet.empty());
    }

    @Test
    public void 비어있지_않은_2개의_NumberSet은_같다() {
        assertThat(NumberSet.fill(1,2,3,4,5,6)).isEqualTo(NumberSet.fill(6,5,4,3,2,1));
    }

    @Test
    public void NumberSet에_이미_값이_있다() {
        assertThat(NumberSet.fill(1,2,3,4,5,6).contains(1)).isTrue();
    }
}
