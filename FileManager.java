package ProyectoFinal;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static ProyectoFinal.RequestFromUser.shiftB;

import static java.nio.file.Files.createFile;

@Slf4j public class FileManager {

    private static List<String> lines;
    public static String secretText;
    public static int shiftToDecrypt;
    public FileManager(){
        this.lines = lines;
        this.secretText = secretText;
        this.shiftToDecrypt = shiftToDecrypt;

    }

    public static void createDirectoryAndFile(String name, String text) {

        Path newPath = null;
        try {
            File file = createFile(newPath = Path.of(name + ".txt").toAbsolutePath()).toFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("new directory and file created at: " + newPath);
    }
    public static void createDirectoryAndFile(String name, int shift){
        Path newPath = null;
        try {
            File file = createFile(newPath = Path.of(name + ".txt").toAbsolutePath()).toFile();
            FileWriter fileWriter = new FileWriter(file);
            String theNumber = String.valueOf(shift);
            fileWriter.write(theNumber);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("new directory and file created at: " + newPath);
    }
    public static void readFile(String newPath){
        Path path = Paths.get(newPath);
        try {
            byte[] bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("Here is the content of your file: \n" + lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        secretText = lines.toString();
    }
    public static void readChangeFile(String path) throws IOException{
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        while (reader.ready()) {
            line = reader.readLine();
        }
        shiftB = Integer.parseInt(line);

    }


}
