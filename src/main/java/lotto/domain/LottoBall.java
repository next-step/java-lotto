package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoBall {
    LottoBall_1(1), LottoBall_2(2), LottoBall_3(3), LottoBall_4(4), LottoBall_5(5),
    LottoBall_6(6), LottoBall_7(7), LottoBall_8(8), LottoBall_9(9), LottoBall_10(10),
    LottoBall_11(11), LottoBall_12(12), LottoBall_13(13), LottoBall_14(14), LottoBall_15(15),
    LottoBall_16(16), LottoBall_17(17), LottoBall_18(18), LottoBall_19(19), LottoBall_20(20),
    LottoBall_21(21), LottoBall_22(22), LottoBall_23(23), LottoBall_24(24), LottoBall_25(25),
    LottoBall_26(26), LottoBall_27(27), LottoBall_28(28), LottoBall_29(29), LottoBall_30(30),
    LottoBall_31(31), LottoBall_32(32), LottoBall_33(33), LottoBall_34(34), LottoBall_35(35),
    LottoBall_36(36), LottoBall_37(37), LottoBall_38(38), LottoBall_39(39), LottoBall_40(40),
    LottoBall_41(41), LottoBall_42(42), LottoBall_43(43), LottoBall_44(44), LottoBall_45(45);

    private final int number;
    LottoBall(int number) {
        this.number = number;
    }

    public static List<LottoBall> lottery() {
        List<LottoBall> convertToList = Arrays.stream(LottoBall.values()).collect(Collectors.toList());
        Collections.shuffle(convertToList);
        return convertToList.subList(0, 6);
    }

    public int getNumber() {
        return this.number;
    }

}
