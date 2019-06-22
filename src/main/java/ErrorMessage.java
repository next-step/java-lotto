public enum ErrorMessage {
    INCORRECT_SEPARATOR("식의 구분자를 정확히 입력해주세요.");
    private String message;
    private ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
