package step2.view.dto;

import step2.domain.Lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    private static final String START_POINT = "[";
    private static final String END_POINT = "]";
    private static final String BLANK = " ";

    private final List<LottoNumberDto> lottoNumberDtos;

    public LottoDto(Lotto lotto) {
        this.lottoNumberDtos = lotto.getValues()
                .stream()
                .map(LottoNumberDto::new)
                .sorted(Comparator.comparing(LottoNumberDto::getValue))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String lottoContent = lottoNumberDtos.stream()
                .map(Object::toString)
                .collect(Collectors.joining(BLANK));
        return START_POINT + lottoContent + END_POINT;
    }
}
