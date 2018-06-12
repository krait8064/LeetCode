package TopInterviewQuestions.ArrayAndStrings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(convert2String(group(arr)));
    }

    public static List<List<String>> group(String[] args) {
        if (args == null || args.length == 1)
            return Collections.EMPTY_LIST;
        Map<String, List<String>> sortedKeyValues = new HashMap<>(args.length / 2);
        String key;
        List<String> values;
        for (String arg : args) {
            key = sortKeyChars(arg);
            if (sortedKeyValues.containsKey(key)) {
                values = sortedKeyValues.get(key);
                values.add(arg);
            } else {
                values = new ArrayList<>();
                values.add(arg);
                sortedKeyValues.put(key, values);
            }
        }
        return new ArrayList<>(sortedKeyValues.values());
    }

    private static String sortKeyChars(String arg) {
        if (arg.length() <= 1)
            return arg;
        char[] chars = arg.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static String convert2String(List<List<String>> data) {
        StringBuilder sb = new StringBuilder();
        for (List<String> item : data) {
            sb.append(item.toString() + "\n");
        }
        return sb.toString();
    }
}
