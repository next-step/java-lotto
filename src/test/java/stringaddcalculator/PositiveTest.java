package stringaddcalculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class PositiveTest {


    @Test
    public void 생성후_값_가져오기() {
        Positive positive = new Positive(3);

        assertThat(positive.getNumber()).isEqualTo(3);
    }

    @Test
    public void 객체_일치() {
        Positive positive1 = new Positive(3);
        Positive positive2 = new Positive(3);

        assertEquals(positive1, positive2);
    }

    @Test
    public void 덧셈_후_결과() {
        Positive positive = new Positive(2);

        assertEquals(new Positive(7), positive.add(new Positive(5)));
    }
}
