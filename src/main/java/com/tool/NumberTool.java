package com.tool;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberTool {

    // 取得2個double值相減
    public static double getSubtractDouble(double today, double yesterday) {
        BigDecimal delta = BigDecimal.valueOf(today).subtract(BigDecimal.valueOf(yesterday));
        return delta.doubleValue();
    }

    // 取得2個double值相除
    public static Double getDivideDouble(double delta, double yesterday, int scale) {
        double temp = delta / yesterday;
        return BigDecimal.valueOf(temp).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

}
