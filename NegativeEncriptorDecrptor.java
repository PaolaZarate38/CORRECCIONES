package ProyectoFinal;

public class NegativeEncriptorDecrptor implements ShiftPositiveOrNegative{
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
}
