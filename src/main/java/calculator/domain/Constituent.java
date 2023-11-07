package calculator.domain;

import calculator.factory.AccountFactory;
import calculator.validation.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class Constituent {

    private List<Integer> numbers;
    private List<String> accounts;
    private static final InputValidation INPUT_VALIDATION = new InputValidation();

    public Constituent(List<String> input) {
        INPUT_VALIDATION.validation(input);
        this.numbers = new ArrayList<>();
        this.accounts = new ArrayList<>();

        for (int step = 0; step < input.size(); step++) {
            addNumberAndAccount(step, input.get(step));
        }
    }

    private void addNumberAndAccount(int step, String input) {
        if (step % 2 == 0) {
            this.numbers.add(Integer.parseInt(input));
        }
        if (step % 2 == 1) {
            this.accounts.add(input);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public int StartCounter() {
        int result = numbers.get(0);
        for (int cal = 0; cal < accounts.size(); cal++) {
            result = AccountFactory.getAccountInstance(accounts.get(cal)).calculate(result, numbers.get(cal + 1));
        }
        return result;
    }
}
