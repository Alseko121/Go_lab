package lab3.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {
    private Pattern pattern;
    private Matcher m;

    public static void main(String[] args) {
        FindText findText = new FindText();
        findText.searchText();
    }

    public void searchText() {
        BufferedReader reader;
        int c = 0;

        try {
            reader = new BufferedReader(new FileReader("C:/Users/murat/IdeaProjects/Java_labs/lab3/gettys.html"));

            String line = reader.readLine();

            Pattern pattern1 = Pattern.compile("<h4>");

            Pattern pattern2 = Pattern.compile("\\bto\\b");

            Pattern pattern3 = Pattern.compile("^<[p|d]");

            Pattern pattern4 = Pattern.compile("^</.*?>$");

            while (line != null) {
                c++;

                if (pattern1.matcher(line).find() ||
                        pattern2.matcher(line).find() ||
                        pattern3.matcher(line).find() ||
                        pattern4.matcher(line).find()) {
                    System.out.println(c + " " + line);
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}