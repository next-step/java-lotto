package humbledude.lotto;

public class AccountManager {

    private long totalSpent = 0;
    private long totalPrize = 0;

    public void addSpent(long spent) {
        totalSpent += spent;
    }

    public void addPrize(long prize) {
        totalPrize += prize;
    }

    public double getProfitRate() {
        return (double) totalPrize / (double) totalSpent;
    }
}
