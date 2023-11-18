package lotto.ui.dto;

import lotto.domain.MyLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyLottosResponse {
    private final List<LottoResponse> lottos = new ArrayList<>();

    public MyLottosResponse(List<LottoResponse> lottos) {
        this.lottos.addAll(lottos);
    }

    public static MyLottosResponse from(MyLottos myLottos) {
        return new MyLottosResponse(
                myLottos.getLottos()
                        .stream().map(LottoResponse::from)
                        .collect(Collectors.toList()));
    }

    public List<LottoResponse> getLottos() {
        return lottos;
    }
}
