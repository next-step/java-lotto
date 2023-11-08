package calculator.domain;

public class Input {

    private final String text;

    public Input(String text) {
        validateEmptyOrNull(text);
        this.text = text;
    }

    public void validateEmptyOrNull(String text) {
        if(this.text == null || this.text.isBlank()){
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
    }

}
