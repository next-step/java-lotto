package lotto.domain;

import lotto.view.LottoMessage;
import lotto.view.PassivityLottoNumberRequest;

import java.util.*;

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
        final Set<LottoNumber> inputLottoNumbers = new HashSet<>();

        Collections.shuffle(LottoNumber.getLottoNumberList());
        for (Integer ln : lottoNumberList.subList(0, 6)) {
            inputLottoNumbers.add(new LottoNumber(ln));
        }
        lottoNumberSet = new LottoNumbers(inputLottoNumbers);
        LottoMessage.getLottoMessage(inputLottoNumbers);
        return lottoNumberSet;
    }

    public List<LottoNumbers> getPurchasesLottoList() {
        return purchasesLottoList;
    }

    private void lottoPassivitySet(List<LottoNumbers> PassivityLottoNumber) {
        for (int i = 0; i < PassivityLottoNumber.size(); i++) {
            purchasesLottoList.add(PassivityLottoNumber.get(i));
            LottoMessage.getLottoMessage(PassivityLottoNumber.get(i).getLottoNumber());
        }
    }
}
