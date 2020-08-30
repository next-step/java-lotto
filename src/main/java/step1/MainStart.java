package step1;

public class MainStart {
    public static void main(String[] args) {
        String userInput = UserInput.getUserInput();
        int result = StringAddCalculator.splitAndSum(userInput);
        System.out.println(result);
    }
}
