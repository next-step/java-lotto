package domain;

public class QuestionValidation {

  public static void validateQuestion(String question) {
    if (question == null || question.equals(" ")) {
      throw new IllegalArgumentException("입력된 값이 없습니다");
    }
  }
}
