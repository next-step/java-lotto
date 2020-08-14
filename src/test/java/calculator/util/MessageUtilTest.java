package calculator.util;

import calculator.context.Message;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MessageUtilTest {
    @Test
    void msgPrint() {
        MessageUtil.msgPrint(Message.OUTPUT_MSG, Arrays.asList("10"));
    }
}