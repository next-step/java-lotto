package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChanceTest {

    @Test
    public void 찬스가_주어졌을_때_찬스가_남았는지_확인할_수_있다(){
        //given
        Chance chance = new Chance(10);
        //when
        boolean result = chance.isLeft();
        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 찬스가_주어졌을_때_찬스를_1회_소모한_후_결과를_확인할_수_있다(){
        //given
        Chance chance = new Chance(1);
        //when
        Chance chanceUsedOnce = chance.useOnce();
        //then
        assertThat(chanceUsedOnce.isLeft()).isFalse();
    }

    @Test
    public void 찬스가_없을_때_1회_소모를_시도한다면_익셉셥이_발생한다(){
        //given
        Chance chance = new Chance(0);
        //when
        //then
        assertThatThrownBy(chance::useOnce)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("더이상 찬스를 사용할 수 없습니다.");
    }

    @Test
    public void Chance에서_빼기를_할_수_있다(){
        //given
        Chance chance1 = new Chance(10);
        Chance chance2 = new Chance(3);
        //when
        Chance chance3 = chance1.subtract(chance2);
        //then
        assertThat(chance3).isEqualTo(new Chance(7));
    }
}
