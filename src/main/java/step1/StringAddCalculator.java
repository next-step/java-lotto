package step1;


public class StringAddCalculator {

    private ValidationCheck validationCheck = new ValidationCheck();

    public int checkInputNumber(String inputNumbers) {
        int check = validationCheck.inputNumberCheckIsEmpty(inputNumbers);
        return check;
    }

    public int add(int[] numberToAdd) {
        int addedNumber = 0;
        for (int index = 0; index < numberToAdd.length; index++) {
            addedNumber += numberToAdd[index];
        }
        return addedNumber;
    }

}
