package vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void of_문자열_숫자() {
        //Give
        Lotto lotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        //When
        Lotto resultLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        //Then
        assertThat(lotto).isEqualTo(resultLotto);
    }

    @Test
    public void of_Set() {
        //Give
        HashSet lotto = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6));
        //When
        Lotto resultLotto = Lotto.ofComma("1,2,3,4,5,6");
        //Then
        assertThat(Lotto.of(lotto)).isEqualTo(resultLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_중복_값() {
        //Give
        //When
        //Then
        Lotto.ofComma("1, 2, 3, 4, 5, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_문자열_isNull() {
        //Give
        //When
        //Then
        Lotto.ofComma("");
    }

    @Test
    public void match() {
        //Give
        Lotto userLotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        //When
        Lotto winningLotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        //Then
        assertThat(userLotto.match(winningLotto)).isEqualTo(6);
    }
}