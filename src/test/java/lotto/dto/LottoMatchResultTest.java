package lotto.dto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchResultTest {

    LottoMatchResult lottoMatchResult;

    @Before
    public void setUp() {
        lottoMatchResult = new LottoMatchResult(new Money(1000));
    }

    @Test
    public void 맞춘개수_증가값_확인() {
    }

    @Test
    public void enum테스트() {
        Type type = Type.valueOf("THREE");
        type.setMatchCount();
        type.setMatchCount();
        type.setMatchCount();
        assertThat(type.numberMatchCount).isEqualTo(3);
    }
}

enum Type {
    THREE(3, 5000, 0), FOUR(4, 50000, 0), FIVE(5, 1500000, 0), SIX(6, 2000000000, 0);

    public final int numberMatchCount;
    public final int money;
    public int matchCount;

    private Type(int numberMatchCount, int money, int matchCount) {
        this.numberMatchCount = numberMatchCount;
        this.money = money;
        this.matchCount = matchCount;
    }

    public void setMatchCount() {
        this.matchCount += 1;
    }
}