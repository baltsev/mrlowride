public class FinancialAnalyst {
    /**
     * Метод findBestDeal(...) находит наилучшие два дня
     * для покупки и продажи чего-либо с максимальной выгодой,
     * основываясь на ценовой динамике.
     *
     * @param   priceArray Массив цен на товар
     * @return  Возвращает массив вида [День покупки, День продажи, Выгода]
     */
    public static int[] findBestDeal(int[] priceArray) {

        // Формируем массив изменений Delta
        int Delta[] = new int[priceArray.length - 1];
        for (int i = 0; i < priceArray.length - 1; i++) {
            Delta[i] = priceArray[i + 1] - priceArray[i];
        }

        int bestStart = 0, bestEnd = 0, highestIncome = 0;   // Наилучший вариант

        Integer start = null;                                // Текущий вариант
        int end = 0, income = 0;


        /*
             I.  Перебирая массив цен, ищем интервалы где скупать товар будет не в убыток
             II. Находим среди них лучший
         */

        for (int i = 0; i < priceArray.length - 1; i++) {
            int delta = Delta[i];

            if (start == null) {
                start = i;
                end = i + 1;
                income = delta;
            } else {
                end++;
                income += delta;
            }

            if (income <= 0) { // Если прибыли нет - переходим к новому интервалу
                start = null;
                end = 0;
                income = 0;
            } else if (income > highestIncome) {
                bestStart = start;
                bestEnd = end;
                highestIncome = income;
            }

        }

        return new int[]{bestStart, bestEnd, highestIncome};
    }
}
