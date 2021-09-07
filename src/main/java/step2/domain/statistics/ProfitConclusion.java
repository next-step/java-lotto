package step2.domain.statistics;

public class ProfitConclusion {
    private static final double STANDARD_OF_PROFIT = 1.0;

    private final String profitConclustion;

    public ProfitConclusion() {
        this("손해");
    }
    public ProfitConclusion(String profitConclustion) {
        this.profitConclustion = profitConclustion;
    }

    public ProfitConclusion profitConclusion(double profitRate) {
        if (profitRate > STANDARD_OF_PROFIT) {
            return new ProfitConclusion("이득");
        }
        return new ProfitConclusion("손해");
    }

    @Override
    public String toString() {
        return String.valueOf(String.valueOf(this.profitConclustion));
    }
}
