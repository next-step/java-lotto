package common.error;

public enum ErrorMessage {

    NO_SUCH_OPERATOR("입력하신 연산자를 확인해 주세요:(");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
