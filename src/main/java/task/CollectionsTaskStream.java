package task;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionsTaskStream {

    public static void main(String[] args) {
        List<String> listString = new ArrayList<>(List.of("80", "80", "Privet", "hello", "vasia", "9034903840,6", "nemo 54", "54,7", "777", "0,12", "apple 15", "Grivet"));
        List<Map<String, String>> listmap = new ArrayList<>(List.of(asMap("1", "Gamma", "2", "80", "4", "Privet", "5", "hello", "7", "9034903840,6", "8", "nemo 54", "3", "80", "9", "54,7", "10", "777", "11", "0,12", "12", "apple 15", "6", "vasia", "13", "Alpha")));
//        System.out.println("54,7".toLowerCase().compareTo("0,12".toLowerCase()));
//        listString = listString.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
        /* Проверьте что список строк отсортирован по алфавиту игнорируя регистр символов. */
        System.out.println(getValuesAndSort(listmap));
        System.out.println(getValuesAndSort2(listmap));


    }

    /* Сгенерируйте список из целых чисел от 1 до Х включительно. */
    public static List<Integer> generateNumbers(int x) {
        return Stream.iterate(1, n -> n + 1)
                .limit(x)
                .collect(Collectors.toList());
    }

    /* Удалите дубликаты из коллекции.*/
    public static <T> void removeDuplicates(Collection<T> collection) {
        collection = collection.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /* Найдите минимальный элемент в коллекции LocalDate. */
    public static LocalDate findMinDate(Collection<LocalDate> collection) {
        return collection.stream().min(LocalDate::compareTo).orElse(null);
    }

    /* Создайте новый список, используя только элементы, стоящие на четных позициях оригинального списка. */
    public static <T> List<T> getEvenElements(List<T> list) {
        return IntStream.range(0, list.size())
                .filter(n -> n % 2 == 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

    /* Создайте новый список из списка строк, используя только строки в виде целых чисел. */
    public static List<String> getOnlyNumbers(List<String> list) { //["10", "1"]   //10
        return list.stream()
                .filter(n -> n.matches("[1-9]\\d*"))
                .collect(Collectors.toList());
    }

    /* Отсортируйте список строк по длине по убыванию. */
    public static void sortByLengthDesc(List<String> list) {
        list = list.stream().sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    /* Перемешайте список, переданный как параметр. */
    public static void mixList(List<?> list) {// не нашёл адекватного решения
        Collections.shuffle(list);
    }


    /* Проверьте что список строк отсортирован по алфавиту игнорируя регистр символов. */
    public static boolean isSortedAlphabeticallyIgnoringCase(List<String> list) { //проверить в один проход!
//        List<String> testList = list.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
//
//        return IntStream.range(0, list.size())
//                .noneMatch(n -> !list.get(n).equals(testList.get(n)));

        return IntStream.range(1, list.size())
                .noneMatch(n -> (((list.get(n).toLowerCase()).compareTo(list.get(n - 1).toLowerCase())) < 0));

    }

    /* Проверьте что в списке чисел нет отрицательных значений. */
    public static boolean checkNoNegativeValues(List<Integer> list) {
        return list.stream().noneMatch(n -> n < 0);
    }

    /* В строке, состоящей из символов (, ), [, ], {, }, проверьте правильность расстановки скобок,
     * вернуть true или false. Символы должны идти парами, пары могут быть вложены друг в друга, но не должны
     * пересекаться. Пример правильного выражения: ({}[]([]){{}[]})
     */
    public static boolean checkBrackets(String sequence) {
        Deque<Character> deque = new ArrayDeque<>();
        sequence.chars()
                .mapToObj(symbol -> (char) symbol)
                .forEach(symbol -> {
                    if (symbol == '[' || symbol == '(' || symbol == '{') {
                        deque.addLast(symbol);
                    } else if (symbol == ']') {
                        if (deque.isEmpty() || deque.removeLast() != '[') {
                            deque.addFirst('!');
                        }
                    } else if (symbol == ')') {
                        if (deque.isEmpty() || deque.removeLast() != '(') {
                            deque.addFirst('!');
                        }
                    } else if (symbol == '}') {
                        if (deque.isEmpty() || deque.removeLast() != '{') {
                            deque.addFirst('!');
                        }
                    }
                });
        return deque.isEmpty();
    }

    //Map

    /* Создайте новый Map из значений, передаваемых в vararg (ключ, значение, ключ, значение, ...).
     * Если количествоаргументов нечетное, выбросить исключение IllegalArgumentException с описанием проблемы и количеством аргументов.
     */
    public static Map<String, String> asMap(String... strings) {

        Map<String, String> map = new HashMap<>();
        IntStream.range(0, strings.length)
                .peek(n -> {
                    if (strings.length % 2 != 0) {
                        throw new IllegalArgumentException("The number of arguments is odd - " + strings.length);
                    }
                })
                .filter(n -> n % 2 == 0)
                .forEachOrdered(n -> map.put(strings[n], strings[n + 1]));
        return map;
    }


    /* Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы перечисления java.time.Month,
     * а значениями - длина названия этого месяца. То есть результат должен быть такой:
     * {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...
     */
    public static Map<Month, Integer> generateMonthAndLengths() {
        return EnumSet.allOf(Month.class).stream().collect(Collectors.toMap(m -> m, m -> m.name().length()));
    }


    /* Создайте новую Map из исходной так, чтобы ключи и значения поменялись местами. При наличии одинаковых значений в
     * исходной Map необходимо выбросить исключение IllegalArgumentException с описанием проблемы и дублирующегося ключа.
     */
    public static <K, V> Map<V, K> inverse(Map<K, V> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue,
                Map.Entry::getKey, (m1, m2) -> {
                    throw new IllegalArgumentException("Duplicate key " + map.get(m1));
                }
        ));
    }

    /* Подсчитайте количество дубликатов каждого элемента в списке. Метод должен возвращать Map<K, Integer>,
     * где K - элемент из списка, а Integer — количество его вхождений в исходный список.
     * Элементы, которые встречаются только 1 раз, не должны входить в результат.
     */
    public static <K> Map<K, Integer> countDuplicates(List<K> list) {

        Map<K, Integer> dublicates = new HashMap<>();
        list.forEach(n -> {
            if (!dublicates.containsKey(n)) {
                dublicates.put(n, 1);
            } else {
                dublicates.put(n, dublicates.get(n) + 1);
            }
        });
        return dublicates;
    }


    /* Трансформируйте List<Map<String, String>> в список всех значений, которые используются в этих Map,
     сортировать по длине, затем по алфавиту. */
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
        List<String> valuesAndSort = new ArrayList<>();
        list.forEach(n -> valuesAndSort.addAll(n.values()));

        return valuesAndSort.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }


    public static List<String> getValuesAndSort2(List<Map<String, String>> list) {

        return list.stream()
                .map(Map::values)
                .flatMap(element -> element.stream())
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() < o2.length())
                            return -1;
                        if (o1.length() > o2.length())
                            return 1;
                        if (o1.length() == o2.length()) {
                            if (o1.compareTo(o2) < 0) {
                                return -1;
                            }
                            if (o1.compareTo(o2) > 0) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                })
                .collect(Collectors.toList());
    }
}




