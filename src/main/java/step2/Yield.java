package step2;

public class Yield {
    private  Yield() {}

    public static double calculate(double winningAmount, double purchaseAmount) {
        if (winningAmount == 0) {
            return 0;
        }
        return Math.floor((winningAmount / purchaseAmount) * 100) / 100.0;
    }
}
