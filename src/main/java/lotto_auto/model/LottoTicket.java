package lotto_auto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private static final Integer LOTTO_NUMBER_MIN_RANGE = 0;
    private static final Integer LOTTO_NUMBER_MAX_RANGE = 45;
    private List<Integer> lottoNumberList;

    public LottoTicket() {
        List<Integer> ret =
                IntStream.range(1, 45)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.shuffle(ret);
        this.lottoNumberList = ret.subList(0, 6);
    }

    public LottoTicket(List<Integer> numbers) {
        ThrowIfNull(numbers);
        ThrowIfInValidLottoNumberCount(numbers);
        ThrowIfInvalidLottoNumberRange(numbers);
        ThrowIfDuplicate(numbers);
        this.lottoNumberList = numbers;
    }

    private void ThrowIfNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void ThrowIfInValidLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void ThrowIfInvalidLottoNumberRange(List<Integer> numbers) {
        List<Integer> filteredList = numbers.stream()
                .filter(item -> item <= LOTTO_NUMBER_MIN_RANGE || item >= LOTTO_NUMBER_MAX_RANGE)
                .collect(Collectors.toList());
        if (filteredList.size() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void ThrowIfDuplicate(List<Integer> numbers) {
        HashSet<Integer> list = new HashSet<>(numbers);
        if (list.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberCount() {
        return this.lottoNumberList.size();
    }

    public List<Integer> export() {
        Collections.sort(this.lottoNumberList);
        return this.lottoNumberList;
    }

    public LottoResult getResult(LottoTicket lottoTicket) {
        int matchNumberCount = getMatchNumberCount(lottoTicket);
        return LottoResult.valueOfMatchNum(matchNumberCount);
    }

    public int getMatchNumberCount(LottoTicket lottoTicket) {
        List<Integer> all = new ArrayList<>();
        all.addAll(this.export());
        all.addAll(lottoTicket.export());
        HashSet<Integer> removeDup = new HashSet<>(all);
        return all.size() - removeDup.size();
    }
}
