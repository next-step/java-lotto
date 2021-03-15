package step2.domain;

import step2.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos() {
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos createLottoList(int count) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
        return this;
    }

    public int lottoCount() {
        return lottoList.size();
    }

    public List<LottoDto> getLottoDtoList() {
        List<LottoDto> list = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            LottoDto lottoDto = new LottoDto(lotto);
            list.add(lottoDto);
        }
        return list;
    }

    public List<Integer> getRankOfLotto(List<LottoNumber> winNumber) {
        return lottoList.stream()
                .map(lotto -> lotto.match(winNumber))
                .collect(toList());
    }
}
