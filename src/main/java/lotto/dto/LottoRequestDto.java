package lotto.dto;

import java.util.List;

public class LottoRequestDto {
    private int money;
    private List<String> lottoNumbers;

    public LottoRequestDto(int money, List<String> lottoNumbers) {
        this.money = money;
        this.lottoNumbers = lottoNumbers;
    }

    public int money() {
        return money;
    }

    public List<String> lottoNumbers() {
        return lottoNumbers;
    }
}
