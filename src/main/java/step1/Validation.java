package step1;

public class Validation {


    private static boolean empty(String text) {
        if (text == null || text.isEmpty())
            return true;

        return false;
    }
}
