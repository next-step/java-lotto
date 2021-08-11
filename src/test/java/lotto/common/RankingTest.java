package lotto.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankingTest {

    @Test
    public void expect가_0이하가_전달되면_잘못된_범위이므로_IllegalArgumentException이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Ranking.getCompensationBy(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("예상 입력값이 잘못되었습니다.");
    }

    @Test
    public void expect가_2이하가_전달되면_보상액이_발생하지_않는다(){
        //given
        //when
        //then
        assertThat(Ranking.getCompensationBy(1)).isEqualTo(0);
    }
}