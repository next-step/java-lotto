package step2_2;

public class InputView {

    public static int readMoney() {
        try {
            return InputUtil.readInt();
        } catch (InvalidMoneyInputException e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

}
