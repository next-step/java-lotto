package calculator.domain;

public class SplitClientInput {

    private final String [] splitClientInput;

    public SplitClientInput(String clientInput) {
        this(clientInput.split(" "));
    }

    public SplitClientInput(String[] splitClientInput) {
        this.splitClientInput = splitClientInput;
    }

}
