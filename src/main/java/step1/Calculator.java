package step1;

public class Calculator {

    public int calculate(String inputValue) {
        inputValue = Validator.inputValueTest(inputValue);

        Tokenizer tokenizer = new Tokenizer();
        String[] stringValueList = tokenizer.splitValue(inputValue);

        return calculateFunction(stringValueList);
    }

    public int calculateFunction(String[] inputValue) {
        int result = 0;
        for (String number: inputValue) {
            result += Validator.validateNumber(number);
        }
        return result;
    }


}
