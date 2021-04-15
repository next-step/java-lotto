package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualNumberGenerator implements LottoNumberGenerator{
    @Override
    public List<Integer> generateNumbers() {
        Scanner scan = new Scanner(System.in);
        String given = scan.nextLine();
        return convertToListFromString(given);
    }

    private List<Integer> convertToListFromString(String given){
        List<Integer> list = new ArrayList<>();
        String[] arr = given.split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            list.add(Integer.parseInt(arr[i]));
        }
        return list;
    }
}
