package calculator.util;

import calculator.context.Message;

import java.util.List;

public class MessageUtil {
    public static void msgPrint(Message message) {
        msgPrint(message, null);
    }

    public static void msgPrint(Message message, List<String> inputTexts) {
        String msg = message.getMsg();
        if (inputTexts != null &&inputTexts.size() > 0) {
            msg = replaceMsg(msg, inputTexts);
        }
        System.out.println(msg);
    }

    private static String replaceMsg(String msg, List<String> inputTexts) {
        for (int i = 1; i <= inputTexts.size(); i++) {
            msg = msg.replace("%" + i, inputTexts.get(i - 1));
        }
        return msg;
    }
}
