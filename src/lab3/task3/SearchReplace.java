package lab3.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {
    private String fileName = "gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";
            String replaceTag = "span";
            String attribute = "class";
            String value = "sentence";
            String line = "";
            int c = 1;

            // Create a Pattern object to match the entire line.
            Pattern pattern1 = Pattern.compile("(<" + targetTag + ".*?>)(.*?)(</" + targetTag + ".*?>)");

            while ((line = reader.readLine()) != null) {
                // Create a matcher
                Matcher m = pattern1.matcher(line);

                // Execute the find() method to find a match
                if (m.find()) {
                    // Replace Start Tag
                    String newStart = replaceTag(m.group(1), targetTag, replaceTag);
                    newStart = replaceAttribute(newStart, attribute, value);

                    // Replace End Tag
                    String newEnd = replaceTag(m.group(3), targetTag, replaceTag);

                    // Reassemble the new line
                    String newLine = newStart + m.group(2) + newEnd;

                    System.out.printf("%3d %s\n", c, newLine);
                }
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to replace contents of any tag
    public String replaceTag(String tag, String targetTag, String replaceTag) {
        Pattern p = Pattern.compile(targetTag);
        Matcher m = p.matcher(tag);
        if (m.find()) {
            return m.replaceFirst(replaceTag);
        }
        return tag;
    }

    // Method to replace a tag's attribute
    public String replaceAttribute(String tag, String attribute, String value) {
        Pattern p = Pattern.compile(attribute + "=" + "\".*?\"");
        Matcher m = p.matcher(tag);
        if (m.find()) {
            return m.replaceFirst(attribute + "=" + "\"" + value + "\"");
        }
        return tag;
    }
}
