package Lotto;

public class ResultBuyView {
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getLottoCount(); i++) {
            System.out.println(lottos.getLottos().get(i).getLottoNumbers().toString());
        }
    }
}
