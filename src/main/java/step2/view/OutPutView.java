package step2.view;

import static java.lang.System.out;

public class OutPutView {

    private static final String END = "[END]";

    public OutPutView() {
        show(END);
    }

    public void show(String output) {
        out.println(output);
    }
}
