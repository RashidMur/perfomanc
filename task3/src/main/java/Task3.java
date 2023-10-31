import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static Map<Integer, String> VALUES_MAP = new HashMap<>();
    public static Gson gson;

    public static void main(String[] args) {
        Scanner scanReport = new Scanner(System.in);
        System.out.println("Укажите путь, куда сохранить файл: ");
        String reportJsonPath = scanReport.nextLine() + "report.json";

        try (Reader testsReader = new FileReader(args[0]);
             Reader valuesReader = new FileReader(args[1]);
             PrintWriter out = new PrintWriter(new FileWriter(reportJsonPath))){

            gson = new Gson();
            Values values = gson.fromJson(valuesReader, Values.class);
            for (Value vl : values.getValues()) {
                VALUES_MAP.put(vl.getId(), vl.getValue());
            }
            Tests tests = gson.fromJson(testsReader, Tests.class);
            for (Test ts : tests.getTests()) {
                setValues(ts);
                gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonString = gson.toJson(ts);
                out.write(jsonString);
            }
            System.out.println("\n" + "Файл успешно сохранен: " + reportJsonPath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void setValues (Test test) {

        for (Integer id : Task3.VALUES_MAP.keySet()){
            if (test.getId() == id) {
                test.setValue(Task3.VALUES_MAP.get(id));
            }
            if (test.getValues() != null) {
                for (Test child : test.getValues()) {
                    setValues(child);
                }
            }
        }
    }
}
