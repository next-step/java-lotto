package domain;

import view.InputValidation;

public class InputValues {

    private String[] inputValues;

    private InputValidation inputValidation;

    public InputValues(String[] values) {
        this.inputValidation = new InputValidation();
        this.inputValues = inputValidation.validationInputValues(values);
    }

    public String[] getInputValues() {
        return inputValues;
    }
}
