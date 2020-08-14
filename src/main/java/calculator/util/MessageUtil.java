package calculator.util;

import calculator.context.Message;

import java.util.List;

public class MessageUtil {
    public static void msgPrint(Message message, List<String> inputTexts) {
        String msg = message.getMsg();
        for (int i = 1; i <= inputTexts.size(); i++) {
            msg = msg.replace("%" + i, inputTexts.get(i - 1));
        }
        System.out.println(msg);
    }
}
