import java.util.List;

public class Solution {

    public int maxDistance(List<List<Integer>> arrays) {
        // Инициализируем переменные для хранения минимального и максимального значений
        int minVal = arrays.get(0).get(0); // Минимальное значение из первого массива
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1); // Максимальное значение из первого массива
        int maxDistance = 0; // Инициализация максимальной дистанции как 0

        // Проходим по всем массивам начиная со второго (индекс 1)
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i); // Текущий массив
            int currentMin = currentArray.get(0); // Минимальное значение текущего массива
            int currentMax = currentArray.get(currentArray.size() - 1); // Максимальное значение текущего массива

            // Обновляем максимальную дистанцию, сравнивая разности текущих минимальных и максимальных значений с предыдущими
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal)); // Расстояние между текущим максимальным и предыдущим минимальным
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin)); // Расстояние между предыдущим максимальным и текущим минимальным

            // Обновляем глобальные минимальные и максимальные значения
            minVal = Math.min(minVal, currentMin); // Обновляем минимальное значение
            maxVal = Math.max(maxVal, currentMax); // Обновляем максимальное значение
        }

        return maxDistance; // Возвращаем максимальную найденную дистанцию
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Пример 1
        List<List<Integer>> arrays1 = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(1, 2, 3)
        );
        System.out.println(solution.maxDistance(arrays1)); // Вывод: 4

        // Пример 2
        List<List<Integer>> arrays2 = List.of(
                List.of(1),
                List.of(1)
        );
        System.out.println(solution.maxDistance(arrays2)); // Вывод: 0
    }
}