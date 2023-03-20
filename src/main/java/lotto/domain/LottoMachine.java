package lotto.domain;

import lotto.view.LottoMessage;
import lotto.view.PassivityLottoNumberRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private List<LottoNumbers> purchasesLottoList = new ArrayList<>();
    private LottoNumbers lottoNumberSet;

    public LottoMachine(LottoPurchases lottoPurchases, List<LottoNumbers> PassivityLottoNumber) {
        lottoPassivitySet(PassivityLottoNumber);
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

    private void lottoPassivitySet(List<LottoNumbers> PassivityLottoNumber) {
        for (int i = 0; i < PassivityLottoNumber.size(); i++) {
            purchasesLottoList.add(PassivityLottoNumber.get(i));
            LottoMessage.getLottoMessage(String.valueOf(PassivityLottoNumber.get(i).getLottoNumber()));
        }
    }
}
