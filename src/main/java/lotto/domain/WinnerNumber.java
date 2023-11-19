package lotto.domain;

import java.util.*;

public class WinnerNumber {
    public boolean compare(String prevWinnerNumber, String userLottoNumber) {
        return Objects.equals(prevWinnerNumber, userLottoNumber);
    }

    public static Map<Integer, Integer> compare(String prevWinnerNumber, List<Integer> userLottoNumber) {
        List<Integer> winnerNumbers = stringToIntWinnerNumbers(prevWinnerNumber.split(","));

        List<Integer[]> userLottoNumberToList = arrayToListValue(userLottoNumber);

        Map<Integer, Integer> correctCount = new HashMap<>();
        for (int i = 0; i < userLottoNumberToList.size(); i++) {

            Integer[] numbers = userLottoNumberToList.get(i);
            System.out.println("numbers = " + Arrays.toString(numbers));


//            for (int j = 0; j < userLottoNumberToList.get(i).length; j++) {
//                System.out.println("userLottoNumberToList = " + Arrays.toString(userLottoNumberToList.get(i)));
//                if (userLottoNumberToList.get(i)[j] == winnerNumbers.get(j)) {
//                    System.out.println("userLottoNumberToList = " + userLottoNumberToList.get(i)[j]);
//                    System.out.println("winnerNumbers = " + winnerNumbers.get(j));
//                    correctCount.put(i, j);
//                }
//            }

        }

        return correctCount;
    }

    private static List<Integer> stringToIntWinnerNumbers(String[] winnerNumbers) {
        List<Integer> values = new ArrayList<>();
        for (String winnerNumber : winnerNumbers) {
            values.add(Integer.parseInt(winnerNumber));
        }
        return values;
    }

    private static List<Integer[]> arrayToListValue(List<Integer> value) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < value.size(); i += 6) {
            Integer[] subArr = new Integer[6];
            for (int j = 0; j < 6; j++) {
                subArr[j] = value.get(i + j);
            }
            list.add(subArr);
        }
        return list;
    }
}
