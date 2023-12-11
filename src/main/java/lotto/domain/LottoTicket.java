package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private List<Lotto> lottoTicket;

    public LottoTicket(Lotto lotto) {
        this.lottoTicket = new ArrayList<>();
        lottoTicket.add(lotto);
    }
    public LottoTicket(List<Lotto> manualLottoList, int number) {
        this.lottoTicket = new ArrayList<>();
        this.lottoTicket.addAll(manualLottoList);
        List<LottoNumber> numbers = numberList();
        for (int i = 0; i < number; i++) {
            Collections.shuffle(numbers);
            lottoTicket.add(new Lotto(List.copyOf(numbers.subList(0, 6))));
        }
    }
    public LottoTicket(int number) {
        this.lottoTicket = new ArrayList<>();
        List<LottoNumber> numbers = numberList();
        for (int i = 0; i < number; i++) {
            Collections.shuffle(numbers);
            lottoTicket.add(new Lotto(List.copyOf(numbers.subList(0, 6))));
        }
    }
    public void match(LottoMachine lottoMachine, WinningLotto winningLotto, LottoStatistics lottoStatistics) {
        for (Lotto lotto: lottoTicket) {
            lottoMachine.rank(lotto, winningLotto, lottoStatistics);
        }
    }
    private static List<LottoNumber> numberList() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .map(el -> new LottoNumber(el))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
