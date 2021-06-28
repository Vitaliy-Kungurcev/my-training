package task;

import java.util.Arrays;

@SuppressWarnings("unchecked")
class DynamicArray<T> {

    private T[] array;

    public DynamicArray() {
        this.array = (T[]) new Object[10];
    }

    public DynamicArray(int size) {
        this.array = (T[]) new Object[size];

    }

    public DynamicArray(T... var) {
        this.array = (T[]) new Object[var.length];
        for (int i = 0; i < var.length; i++) {
            array[i] = var[i];
        }
    }

    private T[] arrayExtension(int desiredSizeList) {
        T[] newArray = (T[]) new Object[desiredSizeList + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

        return array;
    }

    public void addingToTheEnd(T value) {
        try {
            if (array[array.length - 1] != null) {
                arrayExtension(array.length)[array.length - 1] = value;
            } else
                array[array.length - 1] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Array index is out of bounds ");
        }
    }

    public void addingByIndex(T value, int index) {
        try {
            if (array.length - 1 < index) {
                array = arrayExtension(index);
            } else if (array[index] != null) {
                array = arrayExtension(array.length);
                for (int i = array.length - 1; i > index; i--) {
                    array[i] = array[i - 1];
                }
            }
            array[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Array index is out of bounds ");
        }
    }

    public void overwritingByIndex(T value, int index) {
        try {
            array[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Array index is out of bounds ");
        }
    }

    public T getElementByIndex(int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Array index is out of bounds ");
        }
    }


    public void removeElementByIndex(int index) {
        try {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            T[] newArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, newArray.length);
            array = newArray;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Array index is out of bounds ");
        }
    }


    public boolean checkContains(T value) {
//        return Arrays.asList(array).contains(value);
        if (value == null) {
            throw new IllegalArgumentException("value=null");
        }

        for (T element : array) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getSizeList() {
        return array.length;
    }

    public String convertListTostring() {
        StringBuilder arrayToString = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayToString.append('[');
            }
             if (i != array.length - 1) {
                arrayToString.append(array[i])
                        .append(',');
            } else if (i == array.length - 1) {
                arrayToString.append(array[i])
                        .append(']');
            }

        }
        return arrayToString + "";
//        T[] newArray = (T[]) new Object[array.length * 2 + 2];
//
//        for (int i = 0; i < newArray.length - 1; i++) {
//            if (i == 0) {
//                newArray[i] = (T) "[";
//            } else if (i == newArray.length - 2) {
//                newArray[i] = (T) "]";
//            } else if (i % 2 == 0) {
//                newArray[i] = (T) ",";
//            } else {
//                newArray[i] = array[i / 2];
//            }
//        } return "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray<?> that = (DynamicArray<?>) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}