package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lottos create(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(LottoNumber.createLotto());
        }
        return new Lottos(lottoList);
    }

    public List<Integer> toIntegerList() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public long getMatchCountWith(List<LottoNumber> winningLottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public boolean getMatchWith(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
