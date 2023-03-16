package lotto;

public class Lotto {

    public static void main(String[] args) {

        LottoView lottoView = new LottoView();
        int lottobuy = 0;
        LottoDomain lottoDomain;

        lottobuy = (Integer) lottoView.getClientInput(lottoView.step1);
        lottoDomain = new LottoDomain(lottobuy);
        for (int i = 0; i < lottoDomain.getLottoCount(); i++) {
            lottoDomain.addLottoSet("");
        }
    }


}
