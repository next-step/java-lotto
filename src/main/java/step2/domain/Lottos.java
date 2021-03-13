package step2.domain;

import step2.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottoList;

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
        return lottoList.stream()
                .map(LottoDto::new)
                .collect(Collectors.toList());
    }
}
