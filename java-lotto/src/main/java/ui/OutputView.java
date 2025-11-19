package ui;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + "%n", output);
    }
}

