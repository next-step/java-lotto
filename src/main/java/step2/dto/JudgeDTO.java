package step2.dto;

import step2.constants.Price;

import java.util.HashMap;

public class JudgeDTO {

    public static class PriceCountMapDTO{
        private HashMap<Price, Integer> priceCountMap;

        public PriceCountMapDTO(HashMap<Price, Integer> priceCountMap){
            this.priceCountMap = priceCountMap;
        }

        public HashMap<Price, Integer> getPriceCountMap() {
            return priceCountMap;
        }
    }

    public static class JudgeResponseDTO{
        private PriceCountMapDTO priceCountMap;
        private double profit;

        public JudgeResponseDTO(PriceCountMapDTO priceCountMap, double profit){
            this.priceCountMap = priceCountMap;
            this.profit = profit;
        }

        public PriceCountMapDTO getPriceCountMap() {
            return priceCountMap;
        }

        public double getProfit() {
            return profit;
        }
    }
}
