package step4.VO;

public class ManualLottoCnt {
    private final int lottoCnt;

    public ManualLottoCnt(int lottoCnt, Money money) {
        validate(lottoCnt, money);
        this.lottoCnt = lottoCnt;
    }

    private void validate(int lottoCnt, Money money) {
        if (money.compareMoney(lottoCnt)) {
            throw new IllegalArgumentException("수동 발권 숫자는 최대 로또 숫자를 넘을 수 없습니다.");
        }
    }

    public int getManualLottoCnt() {
        return this.lottoCnt;
    }
}
