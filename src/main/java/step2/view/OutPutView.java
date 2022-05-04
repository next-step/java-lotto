package step2.view;

import static java.lang.System.out;

public class OutPutView {

    private static final String END = "[END]";
    private static final String RESULT_LINE = "\n" + "당첨통계" + "---------------\n";

    public OutPutView() {
    }

    public void showResultLine() {
        show(RESULT_LINE);
    }

    public void showEnd() {
        show(END);
    }

    public void show(String output) {
        out.println(output);
    }
}
