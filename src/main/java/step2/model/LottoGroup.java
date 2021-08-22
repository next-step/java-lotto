package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    public LottoGroup(LottoStrategy lottoStrategy, int lottoCount) {
        lottoList = new ArrayList<>();

        while (lottoCount-- > 0) {
            lottoList.add(new Lotto(lottoStrategy.getNumbers()));
        }
    }

    public LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isDigit(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public List<List<Integer>> getLottoResult() {
        List<List<Integer>> result = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            result.add(lotto.getLottoNumbers());
        }

        return result;
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> combineGroup(LottoGroup manualLottoGroup, LottoGroup autoLottoGroup) {
        List<Lotto> allLottoList = new ArrayList<>();
        allLottoList.addAll(autoLottoGroup.getLottoList());
        allLottoList.addAll(manualLottoGroup.getLottoList());
        return allLottoList;
    }
}
