package step4.view;

import step4.domain.LottoNumber;
import step4.domain.Ticket;
import step4.dto.ManualLottoNumberDTO;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPrice() {
        OutputView.printPriceNotification();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        OutputView.printManualLottoCount();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public static List<ManualLottoNumberDTO> inputManualLottoNumbers(Ticket manualLottoTicket) {
        OutputView.printManualLottoNumberNotification();

        Scanner scanner = new Scanner(System.in);
        int ticketCount = manualLottoTicket.getCountOfTicket();
        List<ManualLottoNumberDTO> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            ManualLottoNumberDTO manualLottoNumberDTO = ManualLottoNumberDTO.from(Arrays.
                    stream(scanner.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet()));

            manualLottoNumbers.add(manualLottoNumberDTO);
        }
        return manualLottoNumbers;
    }

    public static Set<LottoNumber> inputWinningNumbers() {
        OutputView.printWinningNumberNotification();
        Scanner scanner = new Scanner(System.in);

        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .mapToObj(number -> LottoNumber.from(number))
                .collect(Collectors.toSet());
    }

    public static int inputBonusBall() {
        OutputView.printBonusBallNotification();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
