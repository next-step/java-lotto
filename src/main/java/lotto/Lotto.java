package lotto;

public class Lotto {
    private static final int DEFAULT_PRICE = 1000;
    private static final String MATCH_PRICE = "^[0-9]+$";
    private static final String EXCEPTION_MESSAGE = "정수만 입력해주세요.";

    private InputView inputView = new InputView();

    public void startPurchase() {
        inputView.printInputPurchasePrice();
        int lottoCount = calculatePrice(validateInputPrice(inputView.inputPurchasePrice()));
        inputView.printPurchasePrice(lottoCount);
    }

    protected int validateInputPrice(String price) {
        if (!price.matches(MATCH_PRICE)) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(price);
    }

    public int calculatePrice(int price) {
        return price / DEFAULT_PRICE;
    }
}
