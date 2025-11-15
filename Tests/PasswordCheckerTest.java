import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

    @Test
    public void testPasswordOk(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("Holahola1","Holahola1");
        Assertions.assertEquals(pc.PASSWORD_OK, code);
    }

    @Test
    public void testErrorLength(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("Hola1","Hola1");
        Assertions.assertEquals(pc.ERR_LENGTH, code);
    }

    @Test
    public void testDigits(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("Holahola","Holahola");
        Assertions.assertEquals(pc.ERR_DIGITS, code);
    }

    @Test
    public void testLowers(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("HOLAHOLA12","HOLAHOLA12");
        Assertions.assertEquals(pc.ERR_UPPERS, code);
    }

    @Test
    public void testUppers(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("holahola12","holahola12");
        Assertions.assertEquals(pc.ERR_LOWERS, code);
    }

    @Test
    public void testPassBlank(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("","");
        Assertions.assertEquals(pc.ERR_BLANK, code);
    }

    @Test
    public void testPassNoMatch(){
        PasswordChecker pc = new PasswordChecker();
        int code = pc.check("Holahola123","Holah123");
        Assertions.assertEquals(pc.ERR_NO_MATCH, code);
    }

    @Test
    public void testPasswordInvalidMinLenght() {
        PasswordChecker pc = new PasswordChecker();

        try{
            pc.setMinLength(-1);
        }
        catch(IllegalArgumentException e){
            Assertions.assertEquals(pc.ERR_INVALID_MIN_LENGTH,e.getMessage());
        }
    }
    @Test
    public void testPasswordInvalidMaxLenght() {
        PasswordChecker pc = new PasswordChecker();

        try{
            pc.setMinLength(1);
        }
        catch(IllegalArgumentException e){
            Assertions.assertEquals(pc.ERR_INVALID_MAX_LENGTH,e.getMessage());
        }
    }

    @Test
    public void testPassNoUppers(){
        PasswordChecker pc = new PasswordChecker();

        pc.setCheckDigits(true);
        pc.setCheckLowers(true);
        int code = pc.check("holahola1","holahola1");
        Assertions.assertEquals(pc.PASSWORD_OK, code);

    }

    @Test
    public void testPassNoLowers(){
        PasswordChecker pc = new PasswordChecker();

        pc.setCheckDigits(true);
        pc.setCheckUppers(true);
        int code = pc.check("HOLAHOLA1","HOLAHOLA1");
        Assertions.assertEquals(pc.PASSWORD_OK, code);

    }

    @Test
    public void testPassNoDigits(){
        PasswordChecker pc = new PasswordChecker();

        pc.setCheckLowers(true);
        pc.setCheckUppers(true);
        int code = pc.check("HolaHola","HolaHola");
        Assertions.assertEquals(pc.PASSWORD_OK, code);

    }

}
