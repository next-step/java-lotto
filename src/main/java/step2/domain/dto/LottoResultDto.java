package step2.domain.dto;

public class LottoResultDto {
    private long countOfMatch;
    private boolean answerOfBonusNumberContent; // 번호 5개일치 상황때만 영향을 주는 속성

    public LottoResultDto(long countOfMatch, boolean answerOfBonusNumberContent) {
        this.countOfMatch = countOfMatch;
        this.answerOfBonusNumberContent = answerOfBonusNumberContent;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isIncludedBonusNumber() {
        return answerOfBonusNumberContent;
    }
}
