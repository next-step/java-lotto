package step2.view.dto;

import step2.domain.PurchaseList;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseListDto {

    private static final String LINE_BREAK = "\n";

    private final List<LottoDto> lottoDtos;

    public PurchaseListDto(PurchaseList purchaseList) {
        this.lottoDtos = purchaseList.getValues()
                .stream()
                .map(LottoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoDtos.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LINE_BREAK));
    }
}
