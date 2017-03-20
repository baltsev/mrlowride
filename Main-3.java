import java.util.Arrays;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int[] testPriceDynamics = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        out.println("Входной массив цен: " + Arrays.toString(testPriceDynamics));

        int[] bestDeal = FinancialAnalyst.findBestDeal(testPriceDynamics);
        int start = bestDeal[0], end = bestDeal[1], income = bestDeal[2];
        if (income == 0) {
            out.println("Пока лучше подождать");
        } else {
            out.printf(
                    "День покупки: %d (%d$)\n" +
                    "День продажи: %d (%d$)\n" +
                            "Прибыль: %d$",
            start + 1, testPriceDynamics[start], end + 1, testPriceDynamics[end], income);
        }
    }
}
