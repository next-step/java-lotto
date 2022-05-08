package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String DELIMITER = ", ";

    private final List<LottoNumber> lottoTicket;

    public LottoTicket(String lottoNumbers) {
        this(toLottoNumberList(lottoNumbers));
    }

    private static List<LottoNumber> toLottoNumberList(String stringLottoNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String lottoNumber : stringLottoNumbers.split(DELIMITER)) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        return lottoNumbers;
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoTicket = lottoNumbers;
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
        }
    }

    public List<String> getLottoNumbers() {
        List<String> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket) {
            lottoNumbers.add(lottoNumber.toString());
        }
        return lottoNumbers;
    }

    public List<LottoNumber> getLottoTicket() {
        return this.lottoTicket;
    }

    public Integer getMatchResult(LottoTicket winningLotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(lottoTicket);
        lottoNumbers.addAll(winningLotto.getLottoTicket());

        return lottoTicket.size() + winningLotto.getLottoTicket().size() - lottoNumbers.size();
    }
}
