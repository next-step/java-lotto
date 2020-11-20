public class StringAdderCalculator {
    private int resultOfOperation = 0;
    String[] operands;

    public int sum(String userInput) {
        if (this.isNullOrEmpty(userInput)) {
            return this.resultOfOperation;
        }

        this.parseOperands(userInput);
        for (String operand : this.operands) {
            this.resultOfOperation += Integer.parseInt(operand);
        }
        return this.resultOfOperation;
    }

    private void parseOperands(String userInput) {
        this.operands = userInput.trim().split(",|:");
    }

    private boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }
}
