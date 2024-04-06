package lotto.service;

public class LottoService {
    public LottoService() {
    }

    public boolean validateManualGameCount(int manualCount, int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException("전체 구매 게임 수 보다 수동게임 구매 숫자가 클 수 없습니다. 입력 게임수를 확인 해주세요.");
        }
        return true;
    }
}
