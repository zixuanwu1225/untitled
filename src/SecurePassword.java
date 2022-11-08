import static java.lang.Integer.parseInt;

public class SecurePassword
{
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    /* Returns true if password:
       - Is at least 8 characters long
       - Contains at least one uppercase letter
       - Contains at least one lowercase letter
       - Contains at least one numeric digit
       - Contains at least one of these "special symbols":  ! @ # $ % ^ & * ?
       Must satisfy ALL FIVE categories for password to be "secure"
       Return false if any of the above security requirements are not fulfilled.
    */
    public boolean isSecure()
    {
        if(!isLongEnough())
            return false;
        if(!containsLowercase())
            return false;
        if(!containsUppercase())
            return false;
        if(!containsDigit())
            return false;
        if(!containsSpecialSymbol())
            return false;
        return true;
    }


    /* Returns a String that contains information about the security status of the
       current password.

       If isSecure() is true, this method returns "Password is secure"
       If isSecure() is false, this methods should return a single String that informs the
       user of which security requirements are not currently being met.

       For example, the password 3WrT6tH does not meet length or special symbol
       requirements, so this method should return the following String (using a line
       break \n):

       "The password must be at least 8 characters
        The password must contain a special symbol: ! @ # $ % ^ & * ?"
    */
    public String status()
    {
        if(!isLongEnough())
            return "Your password needs at least 8 characters";
        if(!containsLowercase())
            return "Your password requires at least one lowercase letter";
        if(!containsUppercase())
            return "Your password requires at least one Uppercase letter";
        if(!containsDigit())
            return "Your password requires at least one digit";
        if(!containsSpecialSymbol())
            return "Your character requires at least one special symbol";
        return "Your password is secure";
    }


    // PRIVATE HELPER METHODS (marked "private" rather than "public")

    /* Returns true if the password’s length meets the minimum requirement of 8 characters
       and false otherwise.
     */
    private boolean isLongEnough()
    {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    /* Returns true if the password has at least one uppercase letter and false otherwise.
     */
    private boolean containsUppercase()
    {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }

    /* Returns true if the password has at least one lowercase letter and false otherwise.
     */
    private boolean containsLowercase()
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    /* Returns true if the password has at least one digit and false otherwise.
     */
    private boolean containsDigit()
    {
        String digits = "123456789";
        return checkString(digits);
    }

    /* Returns true if the password has at least one of these special symbols:
       ! @ # $ % ^ & * ?    and false otherwise.
     */
    private boolean containsSpecialSymbol()
    {
        String symbols = "!@#$%^&*";
        return checkString(symbols);
    }

    /* Checks a given character string to see if password contains at least one
       character from that string.

       For example, if characterString is "ABCDEFGH", and password == "jbHFmfA"
       this method will find two occurrences (F and A) and return true, since two
       is at least one
     */
    private boolean checkString(String characterString)
    {
        String d = "";
        for (int i = 0; i<password.length();i++){
            for(int x = 0; x<characterString.length();x++){
                d=characterString.substring(x,x+1);
                if(password.substring(i, i + 1).equals(d)){
                    return true;
                }
            }
        }
        return false;
    }
}
