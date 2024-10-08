package calculator.io;

public interface OutputHandler {

    void showCommentForArithmeticOperationText();

    void showSimpleMessage(String message);

    void showExceptionMessage(Exception e);

}
