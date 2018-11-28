package TopInterviewQuestions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlUtil {
    public static final String SELECT = "SELECT";
    public static final String SPACE = " ";
    /**
     * sql 数据探查工具
     *
     * @param args: arg0:文件路径，存储字段行
     * arg1:是否添加去重
     * arg2:表名称
     * arg3:分区字段名
     * arg4:起始时间
     * arg5:终止时间
     */

    private List<String> cols;
    private static Map<Boolean, Lib> distinctConf;

    static {
        distinctConf = new HashMap<>();
        distinctConf.put(Boolean.TRUE, new Lib("DISTINCT", "_dc"));
        distinctConf.put(Boolean.FALSE, new Lib("", "_c"));
    }

    public static void main(String[] args) {
        if (args == null || args.length < 3) {
            throw new IllegalArgumentException("请输入正确格式的参数：java SqlUtil.java arg0 arg1 arg2 (arg3-arg5 为可选参数)arg3 arg4 arg5 " +
                    "arg0:文件路径，存储字段行\n" +
                    "arg1:是否添加去重\n" +
                    "arg2:表名称\n" +
                    "arg3:分区字段名\n" +
                    "arg4:起始时间\n" +
                    "arg5:终止时间");
        }
        /**
         * 路径、是否去重、表名
         */
        SqlUtil su = new SqlUtil();
        String path = args[0];
        boolean distinct = Boolean.valueOf(args[1]);
        String tableName = args[2];
        String partition = null;
        String start = null;
        String end = null;
        if (args.length >= 4) {
            partition = args[3];
        }
        if (args.length >= 5) {
            start = args[4];
        }
        if (args.length == 6) {
            end = args[5];
        }
        su.generate(path, distinct, tableName, partition, start, end);
    }

    private void generate(String path, boolean distinct, String tableName, String partition, String start, String end) {
        read(path);
        print(distinct, tableName, partition, start, end);
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

    private void print(boolean distinct, String tableName, String partition, String start, String end) {
        if (cols.size() == 0) {
            throw new IllegalArgumentException("字段文件为空 ");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SELECT).append(SPACE);
        sb.append("COUNT(1) AS AC,");
        cols.forEach(col -> {
            sb.append("COUNT(").append(distinctConf.get(distinct).pre).append(SPACE).
                    append(col).append(")").append(SPACE).append("AS").append(SPACE).
                    append(col).append(distinctConf.get(distinct).suf).append(",");
        });
        sb.delete(sb.length() - 1, sb.length());
        sb.append(SPACE).append("FROM").append(SPACE).append(tableName).append(SPACE);
        sb.append("WHERE").append(SPACE).append(partition).append(SPACE);
        if (partition != null) {
            if (start == null) {
                sb.append("<=").append(SPACE).append(end);
            } else if (end == null) {
                sb.append(">=").append(SPACE).append(start);
            } else {
                sb.append(">=").append(SPACE).append(start).append(SPACE)
                        .append("AND").append(SPACE).append(partition)
                        .append(SPACE).append("<=").append(SPACE).append(end).append(SPACE);
            }
        }
        System.out.println(sb.toString());
    }

    private static class Lib {
        public String pre;
        public String suf;

        public Lib(String pre, String suf) {
            this.pre = pre;
            this.suf = suf;
        }

    }
}
