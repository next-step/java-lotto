package lotto.domain.entity;

import lotto.domain.Lotto;
import lotto.domain.generator.AutomaticLottoNumbersGenerator;
import lotto.domain.generator.LottoNumbersGenerator;

import java.util.*;
import java.util.function.Consumer;

public final class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int automaticLottoPurchaseCount, LottoNumbersGenerator lottoNumbersGenerator) {
        for (int i = 0; i < automaticLottoPurchaseCount; i++) {
            lottoList.add(new Lotto(lottoNumbersGenerator));
        }
    }

    public LottoList(int automaticLottoPurchaseCount, LottoNumbersGenerator lottoNumbersGenerator, Lotto... manualLottos) {
        for (int i = 0; i < automaticLottoPurchaseCount; i++) {
            lottoList.add(new Lotto(lottoNumbersGenerator));
        }
        lottoList.addAll(0, Arrays.asList(manualLottos));
    }

    public LottoList(Lotto... lottoArrays) {
        lottoList.addAll(Arrays.asList(lottoArrays));
    }

    public int size() {
        return lottoList.size();
    }

    public Lotto get(int index) {
        return lottoList.get(index);
    }

    public void forEach(Consumer<? super Lotto> action) {
        Objects.requireNonNull(action);
        for (Lotto lotto : lottoList) {
            action.accept(lotto);
        }
    }

    @Override
    public String toString() {
        return "LottoList = " + lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoList lottoList1 = (LottoList) o;
        return Objects.equals(lottoList, lottoList1.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
