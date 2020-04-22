package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    List<LottoPaper> lottoPapers;

    public LottoBundle() {}

    public LottoBundle(int quantity, List<LottoNumbers> lottoNumbersList) {
        lottoPapers = new ArrayList<>();
        for (int i = 0; i < lottoNumbersList.size(); i++) {
            lottoPapers.add(new LottoPaper(lottoNumbersList.get(i)));
        }
        int autoGameCount =  quantity - lottoNumbersList.size();
        for (int i = 0; i < autoGameCount; i++) {
            lottoPapers.add(new LottoPaper());
        }
    }

    public int getSize() {
        return lottoPapers.size();
    }

    public LottoPaper getLottoPaper(int index) {
        return lottoPapers.get(index);
    }
}
