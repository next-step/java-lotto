package calculator.view;

import calculator.context.Message;
import calculator.util.MessageUtil;

import java.util.Arrays;

public class ResultView {
    private ResultView() {
        throw new AssertionError();
    }

    public static void print(int totalNum) {
        MessageUtil.msgPrint(Message.OUTPUT_MSG, Arrays.asList(String.valueOf(totalNum)));
    }
}
