package step022;

public class Main {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        lottoShop.buyLotto(InputView.inputMoney(), new MakeRandomNumberRule());
    }
}
