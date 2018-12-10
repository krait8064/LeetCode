package TopInterviewQuestions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader {
    /**
     * sql 数据探查工具
     *
     * @param args:
     * arg0:文件路径，存储字段行
     * arg1:分隔符
     */

    private List<String> cols;

    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("请输入正确格式的参数：java SqlUtil.java arg0 arg1 " +
                    "arg0:文件路径，存储字段行\n" +
                    "arg1:分隔符\n"
            );
        }
        /**
         * 路径、是否去重、表名
         */
        LineReader su = new LineReader();
        String path = args[0];
        String sep = String.valueOf(args[1]);
        su.generate(path, sep);
    }

    private void generate(String path, String sep) {
        read(path);
        print(sep);
    }

    private void read(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            cols = new ArrayList<>();
            br.lines().forEach(line -> {
                if (line != null && !(line.trim().isEmpty()))
                    cols.add(line.trim());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(String sep) {
        if (cols.size() == 0) {
            throw new IllegalArgumentException("字段文件为空 ");
        }
        StringBuilder sb = new StringBuilder();
        cols.forEach(col -> sb.append(col).append(sep));
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }

}
