package step02.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step02.domain.LottoList;

public class LottoListDto {

    private final List<LottoDto> lotto = new ArrayList<>();

    public LottoListDto(List<LottoDto> lotto) {
        this.lotto.addAll(lotto);
    }

    public List<LottoDto> getLotto() {
        return lotto;
    }

    public static LottoListDto from(LottoList lottoList) {
        List<LottoDto> lottoDtos = lottoList.getValue().stream()
            .map(LottoDto::from)
            .collect(Collectors.toList());
        return new LottoListDto(lottoDtos);
    }
}
