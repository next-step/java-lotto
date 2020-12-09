package lotto.dto;

import lotto.domain.LottoReport;

public class ReportResponse {

    private final LottoReport lottoReport;

    public ReportResponse(final LottoReport lottoReport) {
        this.lottoReport = lottoReport;
    }

    public static ReportResponse of(final LottoReport lottoReport) {
        return new ReportResponse(lottoReport);
    }
}
