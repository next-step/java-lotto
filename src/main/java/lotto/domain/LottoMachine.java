package lotto.domain;

import lotto.exception.EmptyIssuedLottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoMachine {

    private final static int LOTTO_FIRST_NUMBER = 0;
    private final static int LOTTO_LAST_NUMBER = 6;

    private List<Lotto> lottoTickets = new ArrayList<>();

    public void automaticIssue(List<LottoNumber> lottoNumbers, int count) {
        lottoTickets.addAll(IntStream.range(0, count)
                .mapToObj(i -> randomLotto(lottoNumbers))
                .collect(Collectors.toUnmodifiableList()));
    }

    public void manualIssue(List<String[]> lottoNumbers) {
        lottoTickets.addAll(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<Lotto> lottoTickets() {
        if (lottoTickets.isEmpty()) {
            throw new EmptyIssuedLottoException("발급된 로또가 존재하지 않아, 로또를 조회할 수 없습니다.");
        }
        return lottoTickets.stream().collect(Collectors.toUnmodifiableList());
    }

    private Lotto randomLotto(List<LottoNumber> lottoNumbers) {
        shuffle(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers.subList(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)));
    }
}
