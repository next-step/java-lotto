package step4;

import step4.model.LottoNumberGenerator;
import step4.model.LottoStat;
import step4.model.LottoTicket;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoExtractorMain {
    public static final String DELIMITER = ",";

    public static void main(String[] args) {
        List<LottoTicket> ticketList = new ArrayList<>();
        // 초기금액 입력
        int amount = InputView.askQuestion();
        int numberOfManualLottoTrials = InputView.askNumberOfManualLotto();
        InputView.askManualLottoValue();

        for (int loop = 0; loop < numberOfManualLottoTrials; loop++) {
            ticketList.add(new LottoTicket(InputView.enterManualLottoNumber()));
        }
        LottoNumberGenerator generator = new LottoNumberGenerator();
        // 시도할 횟수값 중간저장
        int trials = InputView.numberOfAutomaticLottoTrials(amount, numberOfManualLottoTrials);
        // 로또 stat용 통계 일급 컬렉션 선언
        LottoStat stat = new LottoStat();

        // 로또 자동생성분에 대한 반복문 수행
        for (int i = 0; i < trials; i++) {
            ticketList.add(generator.generatedLottoTicketByRandom());
            System.out.println(ticketList.get(i).printListMemberWithTemplate());
        }

        // 당첨번호 입력
        String[] answerNumber = InputView.checkWinNumber().split(DELIMITER);
        // 보너스 볼 번호 입력
        int bonusBallNumber = InputView.checkBonusBallNumber();
        // 통계정보에 각각 정보 전달 후 계산
        stat.enterLottoTicketScore(ticketList, answerNumber, bonusBallNumber);
        // 최종 통계 출력
        OutputView.checkStatistics(stat, amount);
    }
}
