package lotto.domain;

import java.util.Objects;

public class Lottery {

    private String s;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;

    // 테스트를 위해 임시로 기본 생성자 추가
    public Lottery() {

    }

    public Lottery(final String s, final String s1, final String s2, final String s3, final String s4, final String s5) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottery lottery = (Lottery) o;
        return Objects.equals(s, lottery.s) &&
                Objects.equals(s1, lottery.s1) &&
                Objects.equals(s2, lottery.s2) &&
                Objects.equals(s3, lottery.s3) &&
                Objects.equals(s4, lottery.s4) &&
                Objects.equals(s5, lottery.s5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, s1, s2, s3, s4, s5);
    }
}
