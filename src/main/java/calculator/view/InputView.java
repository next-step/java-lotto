package calculator.view;

import calculator.util.UserInputHandler;

public class InputView {
    public static String getUserInput(){
        System.out.println("연산하고자 하는 수식을 입력해주세요. (각 문자열은 띄어쓰기를 꼭 넣어주세요.)");

        String userInput = UserInputHandler.scan();
        if(UserInputHandler.checkValidate(userInput)) {
            return userInput;
        }
        return getUserInput();
    }
}
