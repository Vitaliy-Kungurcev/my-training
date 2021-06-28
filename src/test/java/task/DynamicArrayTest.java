package task;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DynamicArrayTest {

    @Test
    public void addingToTheEnd() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.addingToTheEnd(5);
        assertEquals((int) dynamicArray.getElementByIndex(dynamicArray.getSizeList() - 1), 5);
    }

    @Test
    public void addingByIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        dynamicArray.addingByIndex(5, 3);
        dynamicArray2.addingByIndex(5, 3);
        assertEquals((int) dynamicArray.getElementByIndex(3), 5);
        assertEquals((int) dynamicArray.getElementByIndex(3), 5);
    }

    @Test
    public void overwritingByIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        dynamicArray.overwritingByIndex(5, 3);
        dynamicArray2.overwritingByIndex(5, 3);
        assertEquals((int) dynamicArray.getElementByIndex(3), 5);
        assertEquals((int) dynamicArray.getElementByIndex(3), 5);
    }

    @Test
    public void getElementByIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        assertEquals((int) dynamicArray.getElementByIndex(0), 1);
        assertNull(dynamicArray2.getElementByIndex(0));
    }

    @Test
    public void removeElementByIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        dynamicArray.removeElementByIndex(4);
        assertNotEquals((int) dynamicArray.getElementByIndex(4), 5);
        assertEquals((int) dynamicArray.getElementByIndex(4), 6);
    }

    @Test
    public void checkContains() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertTrue(dynamicArray.checkContains(6));
    }

    @Test
    public void getSizeList() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5, 6);
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        assertEquals(dynamicArray.getSizeList(), 6);
        assertEquals(dynamicArray2.getSizeList(), 10);
    }

    @Test
    public void convertListTostring() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1, 2, 3, 4, 5);
        assertEquals(dynamicArray.convertListTostring(), "[1,2,3,4,5]");
    }
}