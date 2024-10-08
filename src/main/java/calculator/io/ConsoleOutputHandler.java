package calculator.io;

public class ConsoleOutputHandler implements OutputHandler {


    @Override
    public void showCommentForArithmeticOperationText() {
        System.out.println("계산식을 입력해주세요. ex) 2 + 3 * 4 / 2");
    }

    @Override
    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
