package main.java.net.androo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {
    private String fileName = /* "src/resources/scripts/ */"src/main/java/net/androo/test.jcl";
    int lineCount = 0;

    public App() {
        String input = fileToString();
        System.out.println(lineCount);
        // String[] args = input.split(" ");
        // String command = args[0];
        // args = removeFirst(args);
        // for (int i = 0; i < lineCount; i++) {
        // switch (command) {
        // case "print":
        // System.out.println(arrayToString(args));
        // break;
        // default:
        // System.out.println(command + ' ' + arrayToString(args));
        // break;
        // }
        // }
    }

    public String arrayToString(String[] s) {
        String temp = "";
        for (int i = 0; i < s.length; i++) {
            temp += s[i] + " ";
        }
        return temp;
    }

    public String[] removeFirst(String[] s) {
        String[] temp = new String[s.length - 1];
        for (int i = 1; i < s.length; i++) {
            temp[i - 1] = s[i];
        }
        return temp;
    }

    public String fileToString() {
        BufferedReader reader;
        String content = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
                System.out.println("Parsing line: " + lineCount);
                parseLine(line);
                lineCount++;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            content = stringBuilder.toString();
        } catch (Exception e) {
            if (e.toString() == "FileNotFoundException") {
                System.out.println("File Not Found");
            } else if (e.toString() == "StringIndexOutOfBoundsException") {
                System.out.println("File has no content");
            } else {
                e.printStackTrace();
            }
        }
        return content;
    }

    public String parseQuotes(String s) {
        if (s.isEmpty())
            return "";
        if (!s.substring(0, 1).equals('"'))
            return "";
        // String temp = "";
        // for (int i = 0; i < s.length(); i++) {
        // temp
        // }
    }

    public void parseLine(String line) {
        String[] args = line.split(" ");
        String command = args[0];
        args = removeFirst(args);
        for (int i = 0; i < lineCount; i++) {
            switch (command) {
                case "//":
                    break;
                case "print":
                    System.out.println(arrayToString(args));
                    break;
                default:
                    System.out.println(command + ' ' + arrayToString(args));
                    break;
            }
        }
    }
}
