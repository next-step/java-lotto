package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void Chance에서_빼기를_할_때_다른_Chance가_더_크면_뺄_수_없고_익셉션이_발생한다(){
        //given
        Chance chance1 = new Chance(3);
        Chance chance2 = new Chance(10);
        //when
        //then
        assertThatThrownBy(() -> chance1.subtract(chance2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("더 큰 수의 찬스를 뺄 수 없습니다.");
    }

    @Test
    public void Chance가_다른_Chance보다_큰지_확인할_수_있다(){
        //given
        Chance chance1 = new Chance(10);
        Chance chance2 = new Chance(3);
        //when
        //then
        assertAll(
                () -> assertTrue(chance1.isBiggerOrEqualThan(chance2)),
                () -> assertFalse(chance2.isBiggerOrEqualThan(chance1))
        );
    }
}
