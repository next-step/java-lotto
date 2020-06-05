package lotto.domain;

import lotto.util.Split;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMemo {
    private final static String COMMA = ",";

    private final List<List<LottoNumber>> lottoMemos = new ArrayList<>();

    private ManualLottoMemo(List<String> manualLottoStrings) {
        try {
            addLottoToMemosFrom(manualLottoStrings);
        }
        catch (NullPointerException ignore) {}
    }

    private void addLottoToMemosFrom(List<String> manualLottoStrings) {
        for (String lottoNumbers : manualLottoStrings) {
            lottoMemos.add(LottoNumberPool.get(Split.from(lottoNumbers, COMMA)));
        }
    }

    public static ManualLottoMemo of(List<String> manualLottoStrings) {
        return new ManualLottoMemo(manualLottoStrings);
    }

    public List<List<LottoNumber>> getLottoMemos() {
        return lottoMemos;
    }

    public List<LottoNumber> getLottoMemo(int index) {
        return lottoMemos.get(index);
    }

    public boolean isEmpty() {
        return lottoMemos.isEmpty();
    }
}
