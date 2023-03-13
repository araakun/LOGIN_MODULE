public class ValidatePassword {
 
    public static void main(String [] args) { 
         final int NUM_UPPER_LETTERS = 2;
         final int NUM_LOWER_LETTERS = 3;
         final int NUM_DIGITS = 1;
         int upperCount = 0;
         int lowerCount = 0;
         int digitCount = 0;
         int letterCount = 0;
         int inputLen = input.length();

         for (int i = 0;  i < inputLen; i++) {
             char ch = input.charAt(i);
             if (Character.isUpperCase(ch))
                 upperCount++;
             else if (Character.isLowerCase(ch))
                 lowerCount++;
             else if (Character.isDigit(ch))
                 digitCount++
             }

            if (upperCount >= NUM_UPPER_LETTERS && lowerCount >= NUM_LOWER_LETTERS && digitCount >= NUM_DIGITS) 
                System.out.println("Valid Password");
            else 
                System.out.println("Invalide Password");
                   if (upperCount < NUM_UPPER_LETTERS)
                      System.out.println("Uppercase letter");
                   else if (lowerCount < NUM_LOWER_LETTERS)
                      System.out.println("Lowercase letter");
                   else if (digitCount < NUM_DIGITS)
                      System.out.println("Digit");
      }
}
