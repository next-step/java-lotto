package lotto.view.dto;

public class ResultResponseDTO {
    private String rank;
    private String matchCount;

    public ResultResponseDTO(String rank, String matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public String getRank() {
        return rank;
    }

    public String getMatchCount() {
        return matchCount;
    }
}
