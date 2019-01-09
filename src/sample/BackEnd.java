package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BackEnd {
    String temp;
    public BackEnd() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("Scores.txt")))) {
            String line;
            while ((line = reader.readLine()) != null)
                temp = reader.readLine();
                System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
