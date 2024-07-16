package ProyectoFinal;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

import static ProyectoFinal.RequestFromUser.shiftB;

@Slf4j public class Main {
    public static void main(String[] args) {


        try {
            RequestFromUser.askForTextnName();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        RequestFromUser shift = new RequestFromUser();
        shift.askForShift();

        RequestFromUser secretFile = new RequestFromUser();
        secretFile.createEncryptedFile();

        log.info("Please enter the path of your encrypted file but please omit {C:} ");
        FileManager tool = new FileManager();
        Scanner scanner = new Scanner(System.in);
        String newPath = scanner.nextLine();
        tool.readFile(newPath);

        log.info("To decryp this text, enter the path of your file with the change");
        FileManager tool2 = new FileManager();
        Scanner scanner2 = new Scanner(System.in);
        String path = scanner2.nextLine();
        try {
            tool2.readChangeFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RequestFromUser decryption = new RequestFromUser();
        decryption.createDecryptedFile();


    }
}