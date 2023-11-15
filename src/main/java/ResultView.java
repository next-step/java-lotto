import java.io.PrintStream;

public class ResultView {

    private final static String CALCULATE_RESULT_MESSAGE = "결과는 \" %d \" 입니다";

    private final PrintStream sout;

    public ResultView(PrintStream sout) {
        this.sout = sout;
    }
    
    public void calculateResult(int result) {
        sout.printf(CALCULATE_RESULT_MESSAGE, result);
    }
}
