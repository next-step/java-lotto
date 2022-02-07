package stringadder;

import java.util.List;
import stringadder.domain.Adder;
import stringadder.utils.StringUtils;
import stringadder.view.UserConsole;
import stringadder.view.UserResult;

public class Application {

    private static Adder adder;
    public static void main(String[] args) {
        adder = new Adder();
        String userInput = UserConsole.inputString();
        List<String> splitResult = StringUtils.splitInput(userInput);

        UserResult.result(adder.add(splitResult));
    }
}
