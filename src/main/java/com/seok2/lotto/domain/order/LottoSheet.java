package com.seok2.lotto.domain.order;

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
        List<LottoSheetRow> mapped = lottoSheetRows.stream()
            .map(StringUtils::split)
            .map(LottoSheetRow::manual)
            .collect(Collectors.toList());
        return new LottoSheet(mapped);
    }

    protected LottoSheetRow next() {
        return Optional.ofNullable(lottoSheetRows.poll())
            .orElse(LottoSheetRow.AUTO);
    }

    protected boolean isNotEmpty() {
        return !lottoSheetRows.isEmpty();
    }

}