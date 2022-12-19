package step2.domain;

public class WinningLotto {

    private Lottos buyLottos;
    private Lotto winningLotto;

    private int first = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double revenue = 0;

    public WinningLotto(Lottos buylottos, Lotto winningLotto) {
        this.buyLottos = buylottos;
        this.winningLotto = winningLotto;
    }
    
    public void match() {
        for (Lotto lotto : buyLottos.getLottoList()) {
            int matchCount = lotto.matchCount(winningLotto);
            matchGrade(matchCount);
        }
        calculateRevenue();
    }

    private void matchGrade(int count) {
        if (count == 3) fifth++;
        if (count == 4) fourth++;
        if (count == 5) third++;
        if (count == 6) first++;
    }

    private void calculateRevenue() {
        int buyCount = buyLottos.buyCount();
        double inputMoney = buyCount * 1000;

        int income = (first * 2000000000) + (third * 1500000) + (fourth * 50000) + (fifth * 5000);

        revenue = income / inputMoney;
    }

    public int getGradeCount(int grade) {
        int result = 0;
        if (grade == 1) result = first;
        if (grade == 3) result = third;
        if (grade == 4) result = fourth;
        if (grade == 5) result = fifth;

        return result;
    }

    public double getRevenue() {
        return revenue;
    }

}
