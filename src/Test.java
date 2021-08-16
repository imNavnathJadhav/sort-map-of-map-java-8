import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Test {
  public static void main(String[] args) {

    Map<Integer, Map<String, Double>> dataSet = getMapDataSet();

    Map<Integer, LinkedHashMap<String, Double>> sortedBySalaray =
        dataSet.entrySet()
        .stream()
        .collect(
            toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(
                        toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                        )
                    )
            )
        );

    System.out.println(sortedBySalaray);
  }

  public static Map<Integer, Map<String, Double>> getMapDataSet() {
    Map<Integer, Map<String, Double>> mainMap = new HashMap<Integer, Map<String, Double>>();

    Map<String, Double> innerMap1 = new HashMap<String, Double>();
    innerMap1.put("John", 10000.0);
    innerMap1.put("Michell", 13000.52);
    innerMap1.put("Dave", 144000.82);
    innerMap1.put("Shane", 50000.12);
    innerMap1.put("Anne", 175000.0);
    mainMap.put(2071, innerMap1);

    Map<String, Double> innerMap2 = new HashMap<String, Double>();
    innerMap2.put("Stuart", 20000.0);
    innerMap2.put("Jennifer", 170000.0);
    innerMap2.put("Michal", 375000.0);
    innerMap2.put("Max", 490000.0);
    innerMap2.put("Johny", 175000.0);
    mainMap.put(2030, innerMap2);
    return mainMap;
  }
}
