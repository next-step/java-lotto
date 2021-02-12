package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;


public class LottoTicket {
    private List<LottoNumber> numbers;
    private LottoNumber bonus;

    // for lotto machine
    public LottoTicket(List<LottoNumber> numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    // for buyer
    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    // for manual lotto ticket
    public LottoTicket(String raw) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        validateRawNnumbers(lottoNumbers, raw);
        this.numbers = lottoNumbers;
    }
    private void validateRawNnumbers(List<LottoNumber> lottoNumbers,String raw){
        List<String> raws = Arrays.asList(raw.split(","));
        raws = raws.stream().map(r -> r.trim()).collect(Collectors.toList());
        if (raws.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개만 입력해야 합니다.");
        }
        try{
            rawToLottoNumbers(lottoNumbers, raws);
        }catch(NumberFormatException nfe){
            throw new NumberFormatException("숫자, 공백, 쉼표(,)만 입력해 주세요.");
        }
    }
    private void rawToLottoNumbers (List<LottoNumber> lottoNumbers, List<String> raws) {
        for(String item : raws){
            int lottoNumber = Integer.parseInt(item);
            lottoNumbers.add( new LottoNumber(lottoNumber) );
        }
    }
    public int countMatches(LottoTicket other) {
        Set<LottoNumber> foo = new HashSet<>(numbers);
        Set<LottoNumber> bar = new HashSet<>(other.numbers);

        foo.retainAll(bar);
        return foo.size();
    }

    public boolean bonusMatches(LottoTicket other) {
        Set<LottoNumber> bar = new HashSet<>(other.numbers);
        return bar.contains(bonus);
    }

    public boolean includeNumber(LottoNumber number) {
        return numbers.indexOf(number) != -1;
    }

    // 티켓 한 장의 정보를 출력
    public List<Integer> getLottoNumbers() {
        List<Integer> ticketNumbers = new ArrayList<>();
        for (LottoNumber number : numbers) {
            ticketNumbers.add(number.getLottoNumber());
        }
        return ticketNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonus;
    }
}
