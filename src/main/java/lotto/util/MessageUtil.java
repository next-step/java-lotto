package lotto.util;

import lotto.context.Message;

import java.util.Arrays;
import java.util.List;

public class MessageUtil {
    public static String getMsg(Message message) {
        return message.getMsg();
    }

    public static String getMsg(Message message, String inputText) {
        return getMsg(message, Arrays.asList(inputText));
    }

    public static String getMsg(Message message, List<String> inputTexts) {
        String msg = message.getMsg();
        if (inputTexts != null && inputTexts.size() > 0) {
            msg = replaceMsg(msg, inputTexts);
        }
        return msg;
    }

    private static String replaceMsg(String msg, List<String> inputTexts) {
        for (int i = 1; i <= inputTexts.size(); i++) {
            msg = msg.replace("%" + i, inputTexts.get(i - 1));
        }
        return msg;
    }
}
