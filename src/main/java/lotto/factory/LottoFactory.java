package lotto.factory;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoTicket;
import lotto.strategy.ManualLottoStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    public static LottoTickets createTickets(List<String> inputs) {
        List<LottoTicket> tickets = inputs.stream()
                .map(input -> parseLottoNumbers(input)) // 문자열 → 숫자 리스트
                .map(numbers -> new ManualLottoStrategy(numbers)) // 전략 생성
                .map(strategy -> LottoTicket.generateLottoNumbers(strategy)) // 티켓 생성
                .collect(Collectors.toList());
        return new LottoTickets(tickets);
    }

    public static LottoTicket createLottoTicket(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers); // LottoTicket 객체 생성 후 반환
    }

    public static WinningLottoTicket createWinningLottoTicket(String input, int bonusNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new WinningLottoTicket(lottoNumbers, LottoNumber.of(bonusNumber)); // LottoTicket 객체 생성 후 반환
    }

    private static List<LottoNumber> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)                      // 각 번호의 공백 제거
                .map(Integer::parseInt)                 // 문자열을 숫자로 변환
                .map(LottoNumber::of)                   // 숫자를 LottoNumber로 변환 (유효성 검증 포함)
                .collect(Collectors.toList());
    }


}
