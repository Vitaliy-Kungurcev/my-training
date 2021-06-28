package task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CollectionsTaskStreamTest {

    @Test
    public void getValuesAndSort2() {
        List<Map<String, String>> listmap = new ArrayList<>(List.of(CollectionsTaskStream.asMap("1", "Gamma", "2", "80", "4", "Privet", "5", "hello", "7", "9034903840,6", "8", "nemo 54", "3", "80", "9", "54,7", "10", "777", "11", "0,12", "12", "apple 15", "6", "vasia", "13", "Alpha")));
        List<String>resultList=new ArrayList<>(List.of("80", "80", "777", "0,12", "54,7", "Alpha", "Gamma", "hello", "vasia", "Privet", "nemo 54", "apple 15", "9034903840,6"));
        assertEquals(CollectionsTaskStream.getValuesAndSort2(listmap),resultList);
    }
}