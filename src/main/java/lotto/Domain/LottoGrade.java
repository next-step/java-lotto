package lotto.Domain;


import java.util.Arrays;
import java.util.Objects;

public enum  LottoGrade {
    win4th(3, 5000.0),
    win3rd(4, 50000.0),
    win2nd(5, 1500000.0),
    win1th(6, 2000000000.0);

    final private Integer grade;
    final private Double prize;

    LottoGrade(Integer grade, Double prize) {
        this.grade = grade;
        this.prize = prize;
    }

    public Integer getGrade() {
        return grade;
    }

    public Double getPrize() {
        return prize;
    }

    public static LottoGrade findGrade(Integer grade) {
        return Arrays.stream(LottoGrade.values())
                .filter(lottoGrade -> Objects.equals(lottoGrade.getGrade(), grade))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
