package lab3.task1;

import java.util.ArrayList;
import java.util.List;

public class StringSplitTest {

    public static void main(String[] args) {
        String[] shirts = new String[5];

        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";

    List<Shirt> shirtList = new ArrayList<>(5);

    // Parse each line of the shirts array and create Shirt objects
        for (String curLine: shirts){
        String[] e = curLine.split(",");
        shirtList.add(new Shirt(e[0], e[1], e[2], e[3]));
    }
        System.out.println("=== Shirt List ===");
        for (Shirt shirt : shirtList) {
        System.out.println(shirt.toString());
        }
}
}