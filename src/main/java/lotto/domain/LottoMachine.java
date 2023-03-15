package lotto.domain;

import lotto.view.LottoMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static List<LottoNumbers> purchasesLottoList = new ArrayList<>();
    private static LottoMessage lottoMessage = new LottoMessage();
    private static LottoNumbers lottoNumberSet;

    public LottoMachine(int number) {
        lottoShuffle(number);
    }

    private void lottoShuffle(int number) {
        for (int i = 0; i < number; i++) {
            purchasesLottoList.add(i, lottoNumberSetting());
        }
    }

    private LottoNumbers lottoNumberSetting() {
        final List<Integer> lottoNumberList = new ArrayList<>();

        if (lottoNumberList.isEmpty()) {
            for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
                lottoNumberList.add(i);
            }
        }
        Collections.shuffle(lottoNumberList);
        lottoNumberSet = new LottoNumbers(lottoNumberList.subList(0, 6));
        lottoMessage.getLottoMessage(String.valueOf(lottoNumberSet.getLottoNumber()));
        return lottoNumberSet;
    }

    public List<LottoNumbers> getPurchasesLottoList() {
        return purchasesLottoList;
    }
}
