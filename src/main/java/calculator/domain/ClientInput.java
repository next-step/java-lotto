package calculator.domain;

public class ClientInput {

    private final String clientInput;

    private static final String EMPTY_MESSAGE = "값이 입력되지 않았습니다.";

    public ClientInput(String clientInput) {
        if(emptyTxt(clientInput)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        this.clientInput = clientInput;
    }

    private boolean emptyTxt(String source) {
        return source == null || source.isEmpty();
    }

}
