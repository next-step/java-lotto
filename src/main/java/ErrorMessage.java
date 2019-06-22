public enum ErrorMessage {
    INCORRECT_VALUE("식이 정확하지 않습니다."),
    INCORRECT_SEPARATOR("식의 구분자를 정확히 입력해주세요."),
    INCORRECT_CUSTOM_SEPARATE("커스텀 구분자가 정확하지 않습니다.");
    private String message;
    private ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
