package ProyectoFinal;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ProyectoFinal.CaesarCipher.decryptText2;
import static ProyectoFinal.CaesarCipher.encryptText2;
import static ProyectoFinal.FileManager.secretText;
import static ProyectoFinal.FileManager.createDirectoryAndFile;

@Slf4j public class RequestFromUser {

    private static String text;
    private static int shift;
    //public static int shift2;
    public static int shiftB;
    private static String name;

    public RequestFromUser(){
        this.text = text;
        this.shift = shift;
        this.shiftB = shiftB;
        this.name = name;

    }
    public static void askForTextnName() throws IOException {
        log.info("Please write (start) then enter, followed by the text to save into a file. \n Once you finish with that click enter onece more and write an |");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();

        System.out.println("");

        List<String> lines = new ArrayList<>();
        while(text != null && !text.endsWith("|")){

            text = br.readLine();
            lines.add(text);
        }
        text = lines.toString();
        System.out.println("Your text is: " + text);

        log.info("now we need a name for your file...");
        BufferedReader nameNormalFile = new BufferedReader(new InputStreamReader(System.in));
        name = nameNormalFile.readLine();
        createDirectoryAndFile(name, text);
    }
    public void askForShift(){
        log.info("Please introuce the shift number to encrypt your file");
        Scanner scanner = new Scanner(System.in);
        shift = scanner.nextInt();

        log.info("Now introduce a name for your file with the shift number");
        Scanner scanner1 = new Scanner(System.in);
        String nameShiftFile = ("change_"+scanner1.nextLine());
        createDirectoryAndFile(nameShiftFile, shift);
    }
    public void createEncryptedFile(){
        String encryptedFileName = ("encrypted_" + name);
        String encryptedText = encryptText2(text, shift);
        createDirectoryAndFile(encryptedFileName, encryptedText);
    }
    public void createDecryptedFile(){
        String normalFileName = ("Decripted_1" + name);
        String normalText = decryptText2(secretText, shiftB);
        createDirectoryAndFile(normalFileName, normalText);
    }
}
