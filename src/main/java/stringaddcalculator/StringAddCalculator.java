public class StringAddCalculator {
    public static int splitAndSum(String inputMessage) {
        if (inputMessage == null || inputMessage.isEmpty()) {
            return 0;
        }
        MessageParser messageParser = new MessageParser();
        Message message = messageParser.parse(inputMessage);
        return message.sumBody();
    }
}
