package lotto.domain;

import lotto.view.LottoMessage;
import lotto.view.PassivityLottoNumberRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static List<LottoNumbers> purchasesLottoList = new ArrayList<>();
    private static LottoNumbers lottoNumberSet;

    public LottoMachine(LottoPurchases lottoPurchases) {
        lottoPassivitySet(lottoPurchases);
        lottoListSet(lottoPurchases);
    }

    private void lottoListSet(LottoPurchases lottoPurchases) {
        for (int i = 0; i < lottoPurchases.getAutomaticCount(); i++) {
            purchasesLottoList.add(lottoShuffle());
        }
    }

    public LottoNumbers lottoShuffle() {
        final List<Integer> lottoNumberList = LottoNumber.getLottoNumberList();

        Collections.shuffle(lottoNumberList);
        lottoNumberSet = new LottoNumbers(lottoNumberList.subList(0, 6));
        LottoMessage.getLottoMessage(String.valueOf(lottoNumberSet.getLottoNumber()));
        return lottoNumberSet;
    }

    public List<LottoNumbers> getPurchasesLottoList() {
        return purchasesLottoList;
    }

    public void lottoPassivitySet(LottoPurchases lottoPurchases) {
        if (lottoPurchases.getPassivityCount() > 0) {
            PassivityLottoNumberRequest passivityLottoNumberRequest = PassivityLottoNumberRequest.inputLottoPrice(lottoPurchases.getPassivityCount());
            LottoMessage.getLottoDivisionMessage(lottoPurchases);

            for (int i = 0; i < lottoPurchases.getPassivityCount(); i++) {
                purchasesLottoList.add(passivityLottoNumberRequest.getLottoNumbersList().get(i));
                LottoMessage.getLottoMessage(String.valueOf(passivityLottoNumberRequest.getLottoNumbersList().get(i).getLottoNumber()));
            }
        }
    }
}
