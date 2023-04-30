package lottery.domain.constant;

public enum LotteryNumberRule {

    LOTTERY_NUMBERS_SIZE(6),
    MIN_LOTTERY_NUMBER(1),
    MAX_LOTTERY_NUMBER(45)
    ;

    private final int ruleNumber;

    LotteryNumberRule(int ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public int getRuleNumber() {
        return this.ruleNumber;
    }

}
