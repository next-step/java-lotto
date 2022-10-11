package lotto;

import java.util.List;

public class LottoCompany {

    private static final int LOTTO_PRICE = 1000;

    private static final int THREE_EQUAL_PRIZE = 5000;
    private static final int FOUR_EQUAL_PRIZE = 50000;
    private static final int FIVE_EQUAL_PRIZE = 1500000;
    private static final int SIX_EQUAL_PRIZE = 2000000000;

    public static LottoResult createLottoResult(List<Integer> lottoNumbers, LottoWallet lottoWallet) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = lottoWallet.getLottos();

        lottoResult.setLottoPrice(LOTTO_PRICE);
        lottoResult.setTotalAmounts(lottos.size());
        setPrizesOf(lottoResult);
        lottos.forEach(lotto -> lottoResult.addWonAmountOf(lotto.countEqualNumbers(lottoNumbers)));

        return lottoResult;
    }

    private static void setPrizesOf(LottoResult lottoResult) {
        lottoResult.setPrizeOf(3, THREE_EQUAL_PRIZE);
        lottoResult.setPrizeOf(4, FOUR_EQUAL_PRIZE);
        lottoResult.setPrizeOf(5, FIVE_EQUAL_PRIZE);
        lottoResult.setPrizeOf(6, SIX_EQUAL_PRIZE);
    }

    public static int getAvailablePurchaseLottoCount(int cashAmount) {
        return cashAmount / LOTTO_PRICE;
    }
}
