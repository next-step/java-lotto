package step2.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumberList;

    public Lotto(String[] lottoNumberList) {
        this(Arrays.stream(lottoNumberList)
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public HitCount isWinningLottoList(WinningLotto winningLotto) {
        return new HitCount(Long.valueOf(winningLotto.getLottoNumberList().stream()
                .filter(winningNumber -> lottoNumberList.contains(winningNumber))
                .count()).intValue());
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberList, lotto.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
