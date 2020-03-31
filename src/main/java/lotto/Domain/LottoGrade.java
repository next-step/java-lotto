package lotto.Domain;


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

    public Double getPrize() {
        return prize;
    }

    public static LottoGrade findGrade(Integer grade) {
        switch (grade) {
            case  3 :
                return LottoGrade.win4th;
            case  4 :
                return LottoGrade.win3rd;
            case  5 :
                return LottoGrade.win2nd;
            case  6 :
                return LottoGrade.win1th;
            default:
                throw new IllegalStateException("Unexpected value: " + grade);
        }
    }
}
