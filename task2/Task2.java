import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task2 {
    public static void main(String[] args) throws IOException {

        String coordinatesAndCentr = new String(Files.readAllBytes(Paths.get(args[0])));
        String[] strings = coordinatesAndCentr.split("\n");
        float R = Float.parseFloat(strings[1]);
        String[] stringsRadius = strings[0].split(" ");
        float x1 = Float.parseFloat(stringsRadius[0]);
        float y1 = Float.parseFloat(stringsRadius[1]);

        String coordinatesPoint = new String(Files.readAllBytes(Paths.get(args[1])));
        String[] stringsPoint = coordinatesPoint.split("\n");
        for (int j = 0; j < stringsPoint.length; j ++) {
            String[] stringsPoint1 = stringsPoint[j].split(" ");
            float x2 = Float.parseFloat(stringsPoint1[0]);
            float y2 = Float.parseFloat(stringsPoint1[(1)]);
            float a = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            if (R == Math.sqrt(a)) {
                System.out.println(0);
            }
            if (R > Math.sqrt(a)) {
                System.out.println(1);
            }
            if (R < Math.sqrt(a)) {
                System.out.println(2);
            }
        }
    }
}
