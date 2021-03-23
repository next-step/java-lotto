package step2.domain;

import step2.domain.lotto.LottoList;
import step2.domain.lotto.WinningLotto;
import step2.dto.JudgeResponseDTO;
import step2.dto.WinningLottoDTO;
import step2.dto.LottoListDTO;
import step2.dto.MatchDTO;
import step2.dto.ShopResponseDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    public JudgeResponseDTO calculateResult(LottoList lottoList, WinningLotto winningLotto) {
        List<MatchDTO> matchList = winningLottoMatchList(shopResponse, winningLotto);
        HashMap<Price, Integer> priceCountMap = convertToPriceCountMap(matchList);
        double profitIndex = calculateProfitIndex(priceCountMap, shopResponse.getOriginMoney());
        return new JudgeResponseDTO(priceCountMap, profitIndex);
    }

    private double calculateProfitIndex(HashMap<Price, Integer> priceCountMap, int originMoney) {
        double moneyWon = Price.FIRST.getPrice() * priceCountMap.get(Price.FIRST) +
                Price.SECOND.getPrice() * priceCountMap.get(Price.SECOND) +
                Price.THIRD.getPrice() * priceCountMap.get(Price.THIRD) +
                Price.FORTH.getPrice() * priceCountMap.get(Price.FORTH) +
                Price.FIFTH.getPrice() * priceCountMap.get(Price.FIFTH);
        return moneyWon / originMoney;
    }

    private HashMap<Price, Integer> convertToPriceCountMap(List<MatchDTO> matchList) {
        HashMap<Price, Integer> priceCountMap = initializePriceCountMap();
        for (MatchDTO matchDTO : matchList) {
            Price price = calculatePrice(matchDTO);
            int count = priceCountMap.get(price);
            priceCountMap.put(price, count + 1);
        }
        return priceCountMap;
    }

    private HashMap<Price, Integer> initializePriceCountMap() {
        HashMap<Price, Integer> priceCountMap = new HashMap<>();
        priceCountMap.put(Price.FIRST, 0);
        priceCountMap.put(Price.SECOND, 0);
        priceCountMap.put(Price.THIRD, 0);
        priceCountMap.put(Price.FORTH, 0);
        priceCountMap.put(Price.FIFTH, 0);
        priceCountMap.put(Price.MISS, 0);
        return priceCountMap;
    }

//    private List<MatchDTO> winningLottoMatchList(ShopResponseDTO shopResponse, WinningLottoDTO winningLotto) {
//        List<Integer> winningNumbers = new ArrayList<>(winningLotto.getNumbers());
//        int bonusNumber = winningLotto.getBonusNumber();
//        LottoListDTO lottoList = shopResponse.getLottoList();
//        return lottoList.getLottoList()
//                .stream()
//                .map(lotto -> new MatchDTO(calculateMatchCount(lotto.getNumbers(), winningNumbers),
//                        match(lotto.getNumbers(), bonusNumber)))
//                .collect(Collectors.toList());
//    }

    private int calculateMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            count += oneIfNumberIsInHashSet(number, winningNumbers);
        }
        return count;
    }

    private int oneIfNumberIsInHashSet(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean match(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private Price calculatePrice(MatchDTO matchDTO) {
        if (thirdPriceOrAbove(matchDTO.getCountOfMatch())) {
            return convertToHighPrice(matchDTO.getCountOfMatch(), matchDTO.getMatchBonus());
        }
        return convertToLowPrice(matchDTO.getCountOfMatch());
    }

    private static boolean thirdPriceOrAbove(int countOfMatch) {
        return countOfMatch >= 5;
    }

    private Price convertToHighPrice(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return Price.FIRST;
        }
        if (countOfMatch == 5 && matchBonus) {
            return Price.SECOND;
        }
        return Price.THIRD;
    }

    private Price convertToLowPrice(int countOfMatch) {
        if (countOfMatch == 4) {
            return Price.FORTH;
        }
        if (countOfMatch == 3) {
            return Price.FIFTH;
        }
        return Price.MISS;
    }

}
