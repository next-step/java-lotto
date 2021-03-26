package step2;

import java.util.stream.Collectors;

public class ResultView {

    public ResultView(){

    }

    public void printPurchaseNumber(PurchaseManager manager) {
        System.out.println(manager.getPurchasedLottoNumber().getNumber()+"개 구매했습니다.");
    }

    public void printLottoList(PurchaseManager purchaseManager) {
        Lottos lottos = Lottos.of(purchaseManager);
        for(Lotto lotto : lottos.getLottos()){
            printLotto(lotto);
            System.out.println();
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.print("[");
        String result = lotto.getLottoNumberList()
                .stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
        System.out.print(result);
        System.out.print("]");
    }
}
