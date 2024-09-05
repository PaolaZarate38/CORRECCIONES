package ProyectoFinal;

public class PositiveEncriptorDecriptor implements ShiftPositiveOrNegative{
    private static final String ALPHABET = (" abcçdefghijklmnñopqrstuvwxyzABCÇDEFGHIJKLMNÑOPQRSTUVWXYZáâãàéêíóóôõúÁÃÀÉÊÍÓÓÔÕÚ0123456789"+
            "[]|.,;:!¡¿?#$%&()+-_=@<>~*/{}");

    public static String encryptText2(String text, int shift) { //ESTE METODO CIFRA Y DECIFRA SI EL CAMBIO ES NEGATIVO
        StringBuilder encryptedText = new StringBuilder();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            int charPosition = ALPHABET.indexOf((text.charAt(i)));
            if(shift > 0){
                int newPosition = (shift + charPosition) % ALPHABET.length();
                char replacement = (ALPHABET.charAt(newPosition));
                encryptedText.append(replacement);
            }else if(shift < 0){
                int newPosition = (shift - charPosition) + ALPHABET.length();
                char replacement = (ALPHABET.charAt(newPosition));
                encryptedText.append(replacement);
            }
        }
        return encryptedText.toString();
    }
    public static String decryptText2(String encryptedText, int shift2) {
        StringBuilder decryptedText = new StringBuilder();
        encryptedText = encryptedText.toLowerCase();
        for (int i = 0; i < encryptedText.length(); i++) {
            int charPosition = ALPHABET.indexOf((encryptedText.charAt(i)));
            int oldPosition = (charPosition - shift2) % ALPHABET.length();
            if (oldPosition < 0) {
                oldPosition = ALPHABET.length() + oldPosition;
            }
            char replace = (ALPHABET.charAt(oldPosition));
            decryptedText.append(replace);
        }
        return decryptedText.toString();
    }
}
