package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void 맞춘_개수를_전달하면_순위가_나온다() {
        assertThat(Rank.calculate(3, false)).isEqualTo(Rank.Fifth);
        assertThat(Rank.calculate(4, false)).isEqualTo(Rank.Fourth);
    }

    @Test
    public void 보너스_번호가_순위에_영향을_미친다() {
        assertThat(Rank.calculate(5, true)).isEqualTo(Rank.Second);
        assertThat(Rank.calculate(5, false)).isEqualTo(Rank.Third);

        assertThat(Rank.calculate(4, false)).isEqualTo(Rank.Fourth);
        assertThat(Rank.calculate(4, true)).isEqualTo(Rank.Fourth);
    }
}
