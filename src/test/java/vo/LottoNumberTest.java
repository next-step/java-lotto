package vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void create() {
        //Give
        //When
        //Then
        assertThat(LottoNumber.of("8")).isEqualTo(LottoNumber.of(8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_1보다_작은_값() {
        //Then
        LottoNumber.of(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_45보다_큰_값() {
        //Then
        LottoNumber.of(46);
    }
}