package task;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTask {

    public static void main(String[] args) {
        List<String> listString = new ArrayList<>(List.of("80", "80", "Privet", "hello", "vasia", "9034903840,6", "nemo 54", "54,7", "777", "050", "0,12", "apple 15", "Privet"));
        List<Integer> listInt = new ArrayList<>(List.of(12, 5, -7, 8, 456, 87, 0, 67, 1, 9));


        /* Сгенерируйте список из целых чисел от 1 до Х включительно. */
        System.out.println(generateNumbers(70));

        /* Удалите дубликаты из коллекции.*/
        removeDuplicates(listString);

        /* Найдите минимальный элемент в коллекции LocalDate. */
        Collection<LocalDate> collection = new ArrayList<>();
        collection.add(LocalDate.of(2021, 6, 17));
        collection.add(LocalDate.of(2021, 6, 17));
        collection.add(LocalDate.of(2020, 6, 17));
        collection.add(LocalDate.of(2021, 6, 13));
        collection.add(LocalDate.of(2021, 6, 16));
        collection.add(LocalDate.of(2021, 12, 17));
        collection.add(LocalDate.of(2021, 1, 1));
        collection.add(LocalDate.of(2021, 6, 1));
        collection.add(LocalDate.of(2021, 6, 1));
        collection.add(LocalDate.of(2021, 6, 17));
        collection.add(LocalDate.of(2021, 6, 17));
        System.out.println(findMinDate(collection));


        /* Создайте новый список, используя только элементы, стоящие на четных позициях оригинального списка. */
        System.out.println(getEvenElements(generateNumbers(70)));


        /* Создайте новый список из списка строк, используя только строки в виде целых чисел. */
        System.out.println(getOnlyNumbers(listString));


        /* Отсортируйте список строк по длине по убыванию. */
        sortByLengthDesc(listString);


        /* Перемешайте список, переданный как параметр. */
        mixList(listString);


        /* Проверьте что список строк отсортирован по алфавиту игнорируя регистр символов. */
        System.out.println(isSortedAlphabeticallyIgnoringCase(listString));


        /* Проверьте что в списке чисел нет отрицательных значений. */
        System.out.println(checkNoNegativeValues(listInt));


        /* В строке, состоящей из символов (, ), [, ], {, }, проверьте правильность расстановки скобок,
         * вернуть true или false. Символы должны идти парами, пары могут быть вложены друг в друга, но не должны
         * пересекаться. Пример правильного выражения: ({}[]([]){{}[]})
         */
        System.out.println(checkBrackets("({}[]([]){{}[]})"));
        System.out.println(checkBrackets("({}[]([)]{{}[]})"));


        //Map
        Map<String, String> mapTest = new HashMap<>();
        mapTest.put("1", "Petrov");
        mapTest.put("11", "Pitrov");
        mapTest.put("2", "Ibragimov");
        mapTest.put("22", "Ivanovich");
        mapTest.put("3", "Sidorov");
        mapTest.put("88", "Balandin");
        mapTest.put("100", "Kah");
        mapTest.put("101", "Kyh");

        /* Создайте новый Map из значений, передаваемых в vararg (ключ, значение, ключ, значение, ...).
         * Если количествоаргументов нечетное, выбросить исключение IllegalArgumentException с описанием проблемы и количеством аргументов.
         */
        System.out.println(asMap("1", "Petrov", "2", "Ivanov", "3", "Sidorov", "100", "Petrov", "Director", "Balin"));
//        System.out.println(asMap("1", "Petrov", "2", "Ivanov", "3", "Sidorov", "100", "Petrov", "Director"));


        /* Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы перечисления java.time.Month,
         * а значениями - длина названия этого месяца. То есть результат должен быть такой:
         * {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...
         */
        System.out.println(generateMonthAndLengths());


        /* Создайте новую Map из исходной так, чтобы ключи и значения поменялись местами. При наличии одинаковых значений в
         * исходной Map необходимо выбросить исключение IllegalArgumentException с описанием проблемы и дублирующегося ключа.
         */
        System.out.println(inverse(mapTest));


        /* Подсчитайте количество дубликатов каждого элемента в списке. Метод должен возвращать Map<K, Integer>,
         * где K - элемент из списка, а Integer — количество его вхождений в исходный список.
         * Элементы, которые встречаются только 1 раз, не должны входить в результат.
         */
        System.out.println(countDuplicates(listString));


        /* Трансформируйте List<Map<String, String>> в список всех значений, которые используются в этих Map, сортировать по длине, затем по алфавиту. */
        List<Map<String, String>> listMap = new ArrayList<>();
        listMap.add(mapTest);
        listMap.add(mapTest);
        listMap.add(mapTest);

        System.out.println(getValuesAndSort(listMap));
    }


    /* Сгенерируйте список из целых чисел от 1 до Х включительно. */
    public static List<Integer> generateNumbers(int x) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < x + 1; i++) {
            numbers.add(i);
        }
        return numbers;
    }


    /* Удалите дубликаты из коллекции.*/
    public static <T> void removeDuplicates(Collection<T> collection) {
        Set<T> set = new LinkedHashSet<>(collection);
        collection.retainAll(set);
        System.out.println(set);
    }


    /* Найдите минимальный элемент в коллекции LocalDate. */
    public static LocalDate findMinDate(Collection<LocalDate> collection) {
        TreeSet<LocalDate> treeSet = new TreeSet<>(collection);
        return treeSet.first();
    }


    /* Создайте новый список, используя только элементы, стоящие на четных позициях оригинального списка. */
    public static <T> List<T> getEvenElements(List<T> list) {
        List<T> evenElements = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            evenElements.add(list.get(i));
        }
        return evenElements;
    }


    /* Создайте новый список из списка строк, используя только строки в виде целых чисел. */
    public static List<String> getOnlyNumbers(List<String> list) {
        List<String> onlyNumbers = new ArrayList<>();
        for (String el : list) {
            if (el.matches("[1-9]\\d+")) {
                onlyNumbers.add(el);
            }
        }
        return onlyNumbers;
    }


    /* Отсортируйте список строк по длине по убыванию. */
    public static void sortByLengthDesc(List<String> list) {
        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(list);
    }


    /* Перемешайте список, переданный как параметр. */
    public static void mixList(List<?> list) {
        Collections.shuffle(list);
        System.out.println(list);
    }


    /* Проверьте что список строк отсортирован по алфавиту игнорируя регистр символов. */
    public static boolean isSortedAlphabeticallyIgnoringCase(List<String> list) {
        List<String> testList = new ArrayList<>(list);
        testList.sort(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < testList.size(); i++) {
            if (!testList.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }


    /* Проверьте что в списке чисел нет отрицательных значений. */
    public static boolean checkNoNegativeValues(List<Integer> list) {
        Collections.sort(list);
        return list.get(0) >= 0;
    }


    /* В строке, состоящей из символов (, ), [, ], {, }, проверьте правильность расстановки скобок,
     * вернуть true или false. Символы должны идти парами, пары могут быть вложены друг в друга, но не должны
     * пересекаться. Пример правильного выражения: ({}[]([]){{}[]})
//     */
    public static boolean checkBrackets(String sequence) {

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                deque.addLast(c);
            } else if (c == ']') {
                if (deque.isEmpty() || deque.removeLast() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (deque.isEmpty() || deque.removeLast() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (deque.isEmpty() || deque.removeLast() != '{') {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    //Map


    /* Создайте новый Map из значений, передаваемых в vararg (ключ, значение, ключ, значение, ...).
     * Если количествоаргументов нечетное, выбросить исключение IllegalArgumentException с описанием проблемы и количеством аргументов.
     */
    public static Map<String, String> asMap(String... strings) {
        if (strings.length % 2 != 0) {
            throw new IllegalArgumentException("The number of arguments is odd - " + strings.length);
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < strings.length; i += 2) {
            map.put(strings[i], strings[i + 1]);
        }
        return map;

    }


    /* Сгенерируйте Map<Month, Integer>, в которой ключами будут элементы перечисления java.time.Month,
     * а значениями - длина названия этого месяца. То есть результат должен быть такой:
     * {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...
     */
    public static Map<Month, Integer> generateMonthAndLengths() {
        Map<Month, Integer> monthAndLengths = new LinkedHashMap<>();
        for (Month m : Month.values()) {
            monthAndLengths.put(m, m.name().length());
        }
        return monthAndLengths;
    }


    /* Создайте новую Map из исходной так, чтобы ключи и значения поменялись местами. При наличии одинаковых значений в
     * исходной Map необходимо выбросить исключение IllegalArgumentException с описанием проблемы и дублирующегося ключа.
     */
    public static <K, V> Map<V, K> inverse(Map<K, V> map) {
        List<V> listValue = new ArrayList<>();
        for (V value : map.values()) {
            if (listValue.contains(value)) {
                throw new IllegalArgumentException("Duplicate key " + value);
            }
            listValue.add(value);
        }
        Map<V, K> map2 = new HashMap<>();
        map.forEach((a, b) -> map2.putIfAbsent(b, a));
        return map2;
    }


    /* Подсчитайте количество дубликатов каждого элемента в списке. Метод должен возвращать Map<K, Integer>,
     * где K - элемент из списка, а Integer — количество его вхождений в исходный список.
     * Элементы, которые встречаются только 1 раз, не должны входить в результат.
     */
    public static <K> Map<K, Integer> countDuplicates(List<K> list) {
        Map<K, Integer> dublicates = new HashMap<>();
        for (K element : list) {
            int count = Collections.frequency(list, element);
            if (count > 1) {
                dublicates.put(element, count);
            }
        }
        return dublicates;
    }

    /* Трансформируйте List<Map<String, String>> в список всех значений, которые используются в этих Map, сортировать по длине, затем по алфавиту. */
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
        List<String> valuesAndSort = new ArrayList<>();
        for (Map<String, String> map : list) {
            valuesAndSort.addAll(map.values());
        }

        return valuesAndSort.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }


}



