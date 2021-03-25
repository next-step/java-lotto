package step2.domain;

public class InputMoney {

    private final Integer inputMoney;

    private InputMoney(int inputMoney) {
        this.inputMoney = Integer.valueOf(inputMoney);
    }

    public static InputMoney valueOf(int inputValue) {
        return new InputMoney(inputValue);
    }

}
