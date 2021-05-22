package lotto;

public class Main {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        Output.showBuyLotto();
        int lottoCount = buyer.buyLotto(Input.insertPurchase());
        Output.showLottoCount(lottoCount);
    }
}
