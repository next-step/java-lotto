package domain;

public class WinStatistic {

    private int matchingNumber;

    private int count;

    private int amount;

    public WinStatistic() { }

    public WinStatistic(int matchingNumber, int count, int amount) {
        this.matchingNumber = matchingNumber;
        this.count = count;
        this.amount = amount;
    }

    public boolean isEmpty() {
        return this.getMatchingNumber() == 0;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseCount() {
        this.count = this.count + 1;
    }

    public int getPrizeAmount(WinStatistic stat) {
        return (stat.getCount() * stat.getAmount());
    }
}
