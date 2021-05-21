package calculator.io.handler;

public enum OutputHandler {
    INSTANCE;

    public void printOut(int calculationResult) {
        System.out.println("Calculation result: " + calculationResult);
    }
}
