package step2;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int lottoNum = InputView.buyLotto()/LOTTO_PRICE;
        InputView.printLottoCount(lottoNum);
    }
}
