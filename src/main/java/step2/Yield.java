package step2;

public class Yield {
    private  Yield() {}

    public static double calculate(double winningAmount, double purchaseAmount) {
        return Math.floor(winningAmount / purchaseAmount * 100) / 100.0;
    }
}
