package lotto.domain;

public class OutputData {

    private static Number threeWin;
    private static Number fourWin;
    private static Number fiveWin;
    private static Number sixWin;
    /**
     * System.out.println("3개 일치(5,000원)- "+inputOutputData.threeWin().number()+"개");
     * System.out.println("4개 일치(50,000원)- "+inputOutputData.fourWin().number()+"개");
     * System.out.println("5개 일치(1,500,000원)- "+inputOutputData.fiveWin().number()+"개");
     * System.out.println("6개 일치(2,000,000,000원)- "+inputOutputData.sixWin().number()+"개");
     */
    private final static Money threeWinMoney = new Money(5000);
    private final static Money fourWinMoney = new Money(50000);
    private final static Money fiveWinMoney = new Money(1500000);
    private final static Money sixWinMoney = new Money(2000000000);
    private Money expense;

    public OutputData(Number threeWin, Number fourWin, Number fiveWin, Number sixWin, Money expense) {
        this.threeWin = threeWin;
        this.fourWin = fourWin;
        this.fiveWin = fiveWin;
        this.sixWin = sixWin;
        this.expense = expense;
    }

    public OutputData(Money expense) {
        this.expense = expense;
    }

    public Number threeWin() {
        return this.threeWin;
    }

    public Number fourWin() {
        return this.fourWin;
    }

    public Number fiveWin() {
        return this.fiveWin;
    }

    public Number sixWin() {
        return this.sixWin;
    }

    public float calculateRate() {
        int profits = this.threeWin().number() * threeWinMoney.won();
        profits += this.fourWin().number() * fourWinMoney.won();
        profits += this.fiveWin().number() * fiveWinMoney.won();
        profits += this.sixWin().number() * sixWinMoney.won();
        return profits / expense.won();
    }

}
