package Lotto;

public class ResultBuyView {
    private final Lottos lottos;
    public ResultBuyView(Lottos lottos) {
        this.lottos = lottos;
    }

    public void printLottos(){
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getLottoCount(); i++) {
            System.out.println(lottos.getLottos().get(i).getLottoNumbers().toString());
        }
    }
}
