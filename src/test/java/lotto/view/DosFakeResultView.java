package lotto.view;

import lotto.domain.LottoList;

public class DosFakeResultView extends DosResultView implements ResultView {
    // 구입한 로또 리스트 출력 과정에 시간이 너무 오래 걸리기 떄문에 해당 과정을 스킵하는 Fake 클래스
    @Override
    public void printLottoList(LottoList lottoList, int manualLottoSize) {}
}
