package calculator.view;

import java.text.DecimalFormat;

public class OutputView {
    private final String result;

    public OutputView(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.result = decimalFormat.format(number);
        System.out.println(result);
    }

    public String print2() {
        return this.result;
    }
}
