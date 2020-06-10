package lotto.domain.data;

import lotto.util.ConvertInt;
import lotto.util.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            List<LottoNumber> manualLotto = Split.from(lottoNumbers, COMMA).stream()
                    .map(s -> LottoNumberPool.get(ConvertInt.from(s)))
                    .collect(Collectors.toList());
            lottoMemos.add(manualLotto);
        }
    }

    public static ManualLottoMemo of(List<String> manualLottoStrings) {
        return new ManualLottoMemo(manualLottoStrings);
    }

    public static ManualLottoMemo empty() {
        return new ManualLottoMemo(null);
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

    public int size() {
        return lottoMemos.size();
    }
}
