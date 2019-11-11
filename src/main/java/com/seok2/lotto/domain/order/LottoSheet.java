package com.seok2.lotto.domain.order;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.common.utils.StringUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class LottoSheet {

    private final Queue<LottoSheetRow> lottoSheetRows;

    private LottoSheet(List<LottoSheetRow> lottoSheetRows) {
        this.lottoSheetRows = new LinkedList<>(lottoSheetRows);
    }

    public static LottoSheet of(List<String> lottoSheetRows) {
        return lottoSheetRows.stream()
            .map(StringUtils::split)
            .map(LottoSheetRow::manual)
            .collect(collectingAndThen(toList(), LottoSheet::new));
    }

    protected LottoSheetRow next() {
        return Optional.ofNullable(lottoSheetRows.poll())
            .orElse(LottoSheetRow.AUTO);
    }

    protected boolean isNotEmpty() {
        return !lottoSheetRows.isEmpty();
    }

}