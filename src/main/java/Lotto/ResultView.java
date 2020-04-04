package Lotto;

public class ResultView {

    public void showQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLottoNumbers(LottoBundle lottoBundle) {
        for (int i = 0; i < lottoBundle.getSize(); i++) {
            LottoPaper tempPaper = lottoBundle.getLottoPaper(i);
            lottoNumberShower(tempPaper);
            System.out.println("");
        }
    }

    public void lottoNumberShower(LottoPaper paper) {
        System.out.print("[");
        for (int i = 0; i < paper.getLength(); i++) {
            System.out.print(paper.getNumber(i));
            System.out.print(",");
        }
        System.out.print("]");
    }
}
