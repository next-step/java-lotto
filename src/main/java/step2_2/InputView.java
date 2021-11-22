package step2_2;

public class InputView {

    public static Money readMoney() {
        try {
            return new Money(InputUtil.readInt());
        } catch (InvalidMoneyInputException e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

}
